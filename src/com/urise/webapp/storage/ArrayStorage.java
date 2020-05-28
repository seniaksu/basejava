package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        if (size == 0) {
            System.out.println("Resume is empty");
        } else {
            Arrays.fill(storage, null);
            size = 0;
        }
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Resume is full");
        } else if (check(r.getUuid()) != -1) {
            System.out.println("Resume already exist");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (size == 0) {
            System.out.println("Resume is empty");
            return null;
        } else if (check(uuid) == -1) {
            System.out.println("There is no such element in Resume");
            return null;
        } else {
            return storage[check(uuid)];
        }
    }

    public void delete(String uuid) {
        int pos;
        if (size == 0) {
            System.out.println("Resume is empty");
        } else if (check(uuid) == -1) {
            System.out.println("There is no such element in Resume");
        } else {
            pos = check(uuid);
            System.arraycopy(storage, pos + 1, storage, pos, size - (pos + 1));
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        resumes = Arrays.copyOf(storage, size);
        return resumes;
    }

    public void update(Resume r) {
        if (check(r.getUuid()) == -1) {
            System.out.println("There is no such element in Resume");
        } else {
            storage[size] = r;
        }
    }

    public int check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
