package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;


public abstract class AbstractStorage implements Storage {

    public Resume get(String uuid) {
        Object searchKey = isExistSearchKey(uuid);
        return getElement(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = isExistSearchKey(resume.getUuid());
        updateElement(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = isNotExistSearchKey(resume.getUuid());
        saveElement(searchKey, resume);
    }

    public void delete(String uuid) {
        Object searchKey = isExistSearchKey(uuid);
        deleteElement(searchKey);
    }

    protected abstract void saveElement(Object searchKey, Resume resume);

    protected abstract void updateElement(Object searchKey, Resume resume);

    protected abstract void deleteElement(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getElement(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    private Object isExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object isNotExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}
