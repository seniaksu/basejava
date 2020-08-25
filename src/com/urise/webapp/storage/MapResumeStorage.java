package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
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
    protected void saveElement(Resume r, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Resume r, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteElement(Resume r) {
        map.remove((r).getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected Resume getElement(Resume r) {
        return r;
    }

    @Override
    protected boolean isExist(Resume r) {
        return r != null;
    }
}

