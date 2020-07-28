package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage  {
    Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Object searchKey, Resume resume) {
        map.put((String) searchKey,resume);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected void deleteElement(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getElement(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
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
