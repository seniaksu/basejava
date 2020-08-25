package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
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
    protected void saveElement(Integer searchKey, Resume resume) {
        list.add(resume);
    }

    @Override
    protected void updateElement(Integer searchKey, Resume resume) {
        list.set(searchKey, resume);
    }

    @Override
    protected void deleteElement(Integer searchKey) {
        list.remove(searchKey.intValue());
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
    protected Resume getElement(Integer searchKey) {
        return list.get(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }
}

