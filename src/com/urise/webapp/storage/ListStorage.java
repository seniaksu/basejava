package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();
    
    @Override
    protected void saveElement(int index, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void updateElement(int index, Resume resume) {
        list.set(index, resume);
    }

    @Override
    protected void deleteElement(int index) {
        list.remove(index);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                    return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getElement(int index) {
        return list.get(index);
    }

    @Override
    protected boolean isExist(int index) {
        return index >=0;
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
