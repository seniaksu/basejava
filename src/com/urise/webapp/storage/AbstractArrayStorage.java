package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected Resume getElement(int index) {
        return storage[index];
    }

    @Override
    protected void updateElement(int index, Resume resume) {
              storage[index] = resume;
    }

    @Override
    public void saveElement(int index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(index, resume);
            size++;
        }
    }

    @Override
    public void deleteElement(int index) {
            fillDeletedElement(index);
            size--;
    }

    @Override
    protected boolean isExist(int index) {
        return index >= 0;
    }

    protected abstract void insertElement(int index, Resume resume);
    protected abstract void fillDeletedElement(int index);
    //protected abstract int getIndex(String uuid);
}