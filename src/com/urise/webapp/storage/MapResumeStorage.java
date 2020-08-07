package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
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
    protected void saveElement(Object searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteElement(Object searchKey) {
        map.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected Resume getElement(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }
}

