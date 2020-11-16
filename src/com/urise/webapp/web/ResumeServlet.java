package com.urise.webapp.web;

import com.urise.webapp.Config;
import com.urise.webapp.model.*;
import com.urise.webapp.storage.Storage;
import com.urise.webapp.util.DateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeServlet extends HttpServlet {
    private final Storage storage = Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String fullName = request.getParameter("fullName");
        Resume resume;
        if (uuid == null || uuid.length() == 0) {
            resume = new Resume(fullName);
        } else {
            resume = storage.get(uuid);
            resume.setFullName(fullName);
        }
        for (ContactType type : ContactType.values()) {
            String value = request.getParameter(type.name());
            if (value == null || value.trim().length() == 0) {
                resume.getContacts().remove(type);
            } else {
                resume.addContact(type, value);
            }
        }
        for (SectionType type : SectionType.values()) {
            String value = request.getParameter(type.name());
            String[] values = request.getParameterValues(type.name());
            if ((value == null || value.trim().length() == 0) && values.length < 2) {
                resume.getSections().remove(type);
            } else {
                switch (type) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.addSection(type, new SingleTextSection(value));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> list = Arrays.asList(value.split("[\\r\\n]+"));
                        resume.addSection(type, new ListSection(list));
                        break;
                    case EDUCATION:
                    case EXPERIENCE:
                        List<Experience> experiences = new ArrayList<>();
                        String[] urls = request.getParameterValues(type.name() + "url");
                        for (int i = 0; i < values.length; i++) {
                            String name = values[i];
                            if (name != null || name.trim().length() != 0) {
                                List<Experience.Position> positions = new ArrayList<>();
                                String[] startDates = request.getParameterValues(type.name() + i + "startDate");
                                String[] endDates = request.getParameterValues(type.name() + i + "endDate");
                                String[] titles = request.getParameterValues(type.name() + i + "title");
                                String[] descriptions = request.getParameterValues(type.name() + i + "description");
                                for (int j = 0; j < titles.length; j++) {
                                    if (titles[j] != null && titles[j].trim().length() != 0) {
                                        positions.add(new Experience.Position(titles[j], DateUtil.parse(startDates[j]), DateUtil.parse(endDates[j]), descriptions[j]));
                                    }
                                }
                                experiences.add(new Experience(new Link(name, urls[i]), positions));
                            }
                        }
                        resume.addSection(type, new OrganizationSection(experiences));
                        break;
                }
            }
        }
        if (uuid == null || uuid.length() == 0) {
            storage.save(resume);
        } else {
            storage.update(resume);
        }
        response.sendRedirect("resume");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            javax.servlet.ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("resumes", storage.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }
        Resume resume;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "save":
                resume = Resume.EMPTY;
                break;
            case "view":
                resume = storage.get(uuid);
                break;
            case "edit":
                resume = storage.get(uuid);
                for (SectionType type : SectionType.values()) {
                    AbstractSection section = resume.getSection(type);
                    switch (type) {
                        case OBJECTIVE:
                        case PERSONAL:
                            if (section == null) {
                                section = SingleTextSection.EMPTY;
                            }
                            break;
                        case ACHIEVEMENT:
                        case QUALIFICATIONS:
                            if (section == null) {
                                section = ListSection.EMPTY;
                            }
                            break;
                        case EXPERIENCE:
                        case EDUCATION:
                            OrganizationSection orgSection = (OrganizationSection) section;
                            List<Experience> experiences = new ArrayList<>();
                            experiences.add(Experience.EMPTY);
                            if (orgSection != null) {
                                for (Experience exp : orgSection.getOrganizations()) {
                                    List<Experience.Position> positions = new ArrayList<>();
                                    positions.add(Experience.Position.EMPTY);
                                    positions.addAll(exp.getPositions());
                                    experiences.add(new Experience(exp.getHomepage(), positions));
                                }
                            }
                            section = new OrganizationSection(experiences);
                            break;
                    }
                    resume.addSection(type, section);
                }
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", resume);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
}
