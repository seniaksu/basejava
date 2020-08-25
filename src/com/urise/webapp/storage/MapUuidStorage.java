package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
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
    protected void saveElement(String uuid, Resume resume) {
        map.put(uuid, resume);
    }

    @Override
    protected void updateElement(String uuid, Resume resume) {
        map.put(uuid, resume);
    }

    @Override
    protected void deleteElement(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getElement(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }
}
