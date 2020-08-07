package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public List<Resume> getAllElement(){
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected Resume getElement(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
              storage[(Integer) index] = resume;
    }

    @Override
    public void saveElement(Object index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement((Integer)index, resume);
            size++;
        }
    }

    @Override
    public void deleteElement(Object index) {
            fillDeletedElement((Integer) index);
            size--;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract void insertElement(int index, Resume resume);
    protected abstract void fillDeletedElement(int index);
    protected abstract Integer getSearchKey (String uuid);
}