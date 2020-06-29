package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("There is no such " + uuid + " in Resume");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("There is no such " + resume.getUuid() + " in Resume");
        } else {
            storage[index] = resume;
        }
    }

    public int size() {
        return size;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Resume is full");
        } else if (index >= 0) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
        } else {
            saveElement(index, resume);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("There is no such " + uuid + " in Resume");
        } else {
            deleteElement(index);
            size--;
        }
    }

    protected abstract void saveElement(int index, Resume resume);
    protected abstract void deleteElement(int index);
    protected abstract int getIndex(String uuid);
}