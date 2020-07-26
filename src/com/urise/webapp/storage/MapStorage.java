package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage  {
    Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Object index, Resume resume) {
        map.put((String) index,resume);
    }

    @Override
    protected void updateElement(Object index, Resume resume) {
        map.put((String) index, resume);
    }

    @Override
    protected void deleteElement(Object index) {
        map.remove((String) index);
    }

    @Override
    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getElement(Object index) {
        return map.get((String) index);
    }

    @Override
    protected boolean isExist(Object index) {
        return map.containsKey((String) index);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
