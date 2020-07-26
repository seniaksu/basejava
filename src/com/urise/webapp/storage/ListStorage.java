package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();
    
    @Override
    protected void saveElement(Object index, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
        list.set((Integer) index, resume);
    }

    @Override
    protected void deleteElement(Object index) {
        list.remove(((Integer) index).intValue());
    }

    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                    return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getElement(Object index) {
        return list.get((Integer) index);
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >=0;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
