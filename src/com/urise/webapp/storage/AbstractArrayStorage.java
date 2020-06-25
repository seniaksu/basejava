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

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("There is no such " + r.getUuid() + " in Resume");
        } else {
            storage[index] = r;
        }
    }

    public int size() {
        return size;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Resume is full");
        } else if (index >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else {
            SaveElement(index, r);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("There is no such " + uuid + " in Resume");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            size--;
        }
    }

    protected abstract void SaveElement(int index, Resume r);
    protected abstract int getIndex(String uuid);
}