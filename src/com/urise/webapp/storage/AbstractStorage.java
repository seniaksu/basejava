package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;

import static java.util.Comparator.*;


public abstract class AbstractStorage implements Storage {

    protected abstract void saveElement(Object searchKey, Resume resume);

    protected abstract void updateElement(Object searchKey, Resume resume);

    protected abstract void deleteElement(Object searchKey);

    protected abstract Resume getElement(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract List<Resume> getAllElement();

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return getElement(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        updateElement(searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        saveElement(searchKey, resume);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        deleteElement(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllElement();
        list.sort(naturalOrder());
        return list;
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
