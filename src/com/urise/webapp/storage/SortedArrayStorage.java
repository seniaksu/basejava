package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(int index, Resume resume) {
        int position = -index - 1;
        System.arraycopy(storage, position, storage, position + 1, size - position);
        storage[position] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
