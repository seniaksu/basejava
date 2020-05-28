package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        if (size == 0)
            System.out.println("com.urise.webapp.model.Resume is empty");
        else {
            for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
            size = 0;
        }
    }

    public void save(Resume r) {
        if (size == storage.length)
            System.out.println("com.urise.webapp.model.Resume is full");
        else {
            storage[size] = r;
            size++;
        }
    }

    public String get(String uuid) {
        String answer = "";
        if (size == 0)
            answer = "com.urise.webapp.model.Resume is empty";
        else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    answer = storage[i].getUuid();
                    break;
                }
            }
        }
        if (answer == "")
            answer = "There is no such element";
        return answer;
    }

    public void delete(String uuid) {
        int pos;
        if (size == 0)
            System.out.println("com.urise.webapp.model.Resume is empty");
        else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = null;
                    pos = i;
                    System.arraycopy(storage, pos + 1, storage, pos, size - (pos + 1));
                    size--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] output = new Resume[size];
        System.arraycopy(storage, 0, output, 0, size);
        return output;
    }

    public int size() {
        return size;
    }
}
