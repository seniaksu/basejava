package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;



public abstract class AbstractStorage implements Storage  {

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(index);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (!isExist(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateElement(index, resume);
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExist(index)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveElement(index, resume);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteElement(index);
        }
    }

    protected abstract void saveElement(int index, Resume resume);
    protected abstract void updateElement(int index, Resume resume);
    protected abstract void deleteElement(int index);
    protected abstract int getIndex(String uuid);
    protected abstract Resume getElement (int index);
    protected abstract boolean isExist (int index);

}
