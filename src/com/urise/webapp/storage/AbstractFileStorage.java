package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;
    private File[] folder;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected void saveElement(File file, Resume resume) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("Error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    @Override
    protected void updateElement(File file, Resume resume) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("Error", file.getName(), e);
        }

    }

    @Override
    protected void deleteElement(File file) {
        file.delete();
    }

    @Override
    protected Resume getElement(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("Error", file.getName(), e);
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAllElement() {
        folder = directory.listFiles();
        List<Resume> list = new ArrayList<>(folder.length);
        for (File file : folder) {
            list.add(getElement(file));
        }
        return list;
    }

    @Override
    public void clear() {
        folder = directory.listFiles();
        for (File file : folder) {
            deleteElement(file);
        }
    }

    @Override
    public int size() {
        folder = directory.listFiles();
        return folder.length;
    }
}
