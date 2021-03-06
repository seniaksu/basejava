package com.urise.webapp.storage.serialization;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(contacts.entrySet(), dos, entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());

            });

            Map<SectionType, AbstractSection> sections = resume.getSections();
            writeCollection(sections.entrySet(), dos, entry -> {
                SectionType type = entry.getKey();
                AbstractSection section = entry.getValue();
                dos.writeUTF(type.name());
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(((SingleTextSection) section).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(((ListSection) section).getContent(), dos, dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeCollection(((OrganizationSection) section).getOrganizations(), dos, org -> {
                            dos.writeUTF(org.getHomepage().getName());
                            dos.writeUTF(org.getHomepage().getUrl());
                            writeCollection(org.getPositions(), dos, position -> {
                                dos.writeUTF(position.getTitle());
                                writeDate(position.getStartDate(), dos);
                                writeDate(position.getEndDate(), dos);
                                dos.writeUTF(position.getDescription());
                            });
                        });
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readSection(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readSection(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.addSection(sectionType, new SingleTextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.addSection(sectionType, new ListSection(readCollection(dis, dis::readUTF)));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        resume.addSection(sectionType, new OrganizationSection(
                                readCollection(dis, () -> new Experience(new Link(dis.readUTF(), dis.readUTF()),
                                        readCollection(dis, () -> new Experience.Position(dis.readUTF(),
                                                readDate(dis), readDate(dis), dis.readUTF()
                                        ))
                                ))));
                }
            });
            return resume;
            }
        }

    private <T> void writeCollection(Collection<T> collection, DataOutputStream dos, Writer<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }

    private void writeDate(YearMonth date, DataOutputStream dos) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonth().getValue());
    }

    private <T> List<T> readCollection(DataInputStream dis, Reader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private void readSection(DataInputStream dis, SectionRead reader) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            reader.sectionRead();
        }
    }

    private YearMonth readDate(DataInputStream dis) throws IOException {
        return YearMonth.of(dis.readInt(), dis.readInt());
    }

    private interface Writer<T> {
        void write(T t) throws IOException;
    }

    private interface Reader<T> {
        T read() throws IOException;
    }
    private interface SectionRead {
        void sectionRead () throws IOException;
    }
}

