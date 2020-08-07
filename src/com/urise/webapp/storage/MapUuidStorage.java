package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllElement() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected void saveElement(Object uuid, Resume resume) {
        map.put((String) uuid, resume);
    }

    @Override
    protected void updateElement(Object uuid, Resume resume) {
        map.put((String) uuid, resume);
    }

    @Override
    protected void deleteElement(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getElement(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey((String) uuid);
    }
}
