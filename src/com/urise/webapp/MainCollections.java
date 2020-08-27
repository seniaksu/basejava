package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final Resume r1 = new Resume("uuid1", "Name1");
    private static final Resume r2 = new Resume("uuid2", "Name2");
    private static final Resume r3 = new Resume("uuid3", "Name3");
    private static final Resume r4 = new Resume("uuid4", "Name4");

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(r1);
        collection.add(r2);
        collection.add(r3);

        for (Resume r : collection) {
            System.out.println(r);
            if (Objects.equals(r.getUuid(), "uuid1")) {
                //   collection.remove(r);
            }
        }
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), "uuid1")) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put("uuid1", r1);
        map.put("uuid2", r2);
        map.put("uuid3", r3);

        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<Resume> resumes = Arrays.asList(r1, r2, r3);

        resumes.remove(1);
        System.out.println(resumes);
    }
}
