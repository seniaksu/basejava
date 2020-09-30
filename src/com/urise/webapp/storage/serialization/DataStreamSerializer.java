package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializer {
    private void writeListSections(List<String> content, DataOutputStream dos) throws IOException {
        for (String s : content) {
            dos.writeUTF(s);
        }
    }

    private ListSection readListSection(DataInputStream dis) throws IOException {
        int size = dis.readInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(dis.readUTF());
        }
        return new ListSection(list);
    }

    private void writeOrganizationSections(List<Experience> organizations, DataOutputStream dos) throws IOException {
        for (Experience s : organizations) {
            dos.writeUTF(s.getHomepage().getName());
            dos.writeUTF(s.getHomepage().getUrl());
            dos.writeInt(s.getPositions().size());
            for (Experience.Position p : s.getPositions()) {
                dos.writeUTF(p.getTitle());
                writeDate(p.getStartDate(), dos);
                writeDate(p.getEndDate(), dos);
                dos.writeUTF(p.getDescription());
            }
        }
    }

    private OrganizationSection readOrganizationSection(DataInputStream dis) throws IOException {
        int size = dis.readInt();
        List<Experience> s = new ArrayList<>();
        List<Experience.Position> p = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = dis.readUTF();
            String url = dis.readUTF();

            int positionSize = dis.readInt();
            for (int j = 0; j < positionSize; j++ ) {
                p.add(new Experience.Position(dis.readUTF(), readLocalDate(dis), readLocalDate(dis), dis.readUTF()));
            }
            s.add(new Experience(name, url, p));
        }
        return new OrganizationSection(s);
    }
    private void writeDate(YearMonth date, DataOutputStream dos) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonth().getValue());
    }

    private YearMonth readLocalDate(DataInputStream dis) throws IOException {
        return YearMonth.of(dis.readInt(), dis.readInt());
    }

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            // TODO implements sections
            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
                SectionType type = entry.getKey();
                AbstractSection section = entry.getValue();
                dos.writeUTF(type.name());
                switch (type){
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(type.name());
                        dos.writeUTF(((SingleTextSection) section).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        dos.writeUTF(type.name());
                        dos.writeInt(((ListSection) section).getContent().size());
                        writeListSections(((ListSection) section).getContent(), dos);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        dos.writeUTF(type.name());
                        dos.writeInt(((OrganizationSection) section).getOrganizations().size());
                        writeOrganizationSections(((OrganizationSection) section).getOrganizations(), dos);
                        break;
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            // TODO implements sections
            int sectionSize = dis.readInt();
            for (int i = 0; i < sectionSize; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.addSection(SectionType.valueOf(dis.readUTF()), new SingleTextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.addSection(SectionType.valueOf(dis.readUTF()), readListSection(dis));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        resume.addSection(SectionType.valueOf(dis.readUTF()), readOrganizationSection(dis));
                        break;
                }
            }
            return resume;
        }
    }
}

