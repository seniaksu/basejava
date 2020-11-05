package com.urise.webapp.web;

import com.urise.webapp.Config;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {
    private Storage storage = Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
//        String name = request.getParameter("name");
//        response.getWriter().write(name == null ? "Hello Resumes!" : "Hello " + name + '!');

        Writer table = response.getWriter();
        table.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <style>\n" +
                "        table, th, td {\n" +
                "            border: 1px solid black;\n" +
                "            border-collapse: collapse;\n" +
                "        }\n" +
                "        th, td {\n" +
                "            padding: 15px;\n" +
                "            text-align: left;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <title>Таблица резюме</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2 align=\"center\" style=\"color:Black\">Таблица резюме</h2>\n" +
                "<p align=\"center\" style=\"color:Black\">Отображение таблицы резюме в сервлете.</p>\n" +
                "<table align=\"center\" style=\"width:50%\">\n" +
                "    <tr>\n" +
                "        <th>UUID</th>\n" +
                "        <th>FullName</th>\n" +
                "    </tr>\n" );
        for (Resume resume : storage.getAllSorted()) {
            table.write(
                    "<tr>\n" +
                            " <td>" + resume.getUuid() + "</td>\n"+
                            " <td>" + resume.getFullName() + "</td>\n"+
                            "</tr>\n");
        }
        table.write("</table>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
