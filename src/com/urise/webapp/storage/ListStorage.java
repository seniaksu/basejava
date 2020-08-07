package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAllElement(){
        return new ArrayList<>(list);
    }
    
    @Override
    protected void saveElement(Object searchKey, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        list.set((Integer) searchKey, resume);
    }

    @Override
    protected void deleteElement(Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                    return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getElement(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >=0;
    }
}

