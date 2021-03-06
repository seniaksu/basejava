package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.*;

public class SortedArrayStorage extends AbstractArrayStorage {
    /*
        private static class ResumeComparator implements Comparator<Resume> {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        }
    */
    private static final Comparator<Resume> RESUME_COMPARATOR = comparing(Resume::getUuid);

    @Override
    protected void insertElement(int index, Resume resume) {
        int position = -index - 1;
        System.arraycopy(storage, position, storage, position + 1, size - position);
        storage[position] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int position = index + 1;
        System.arraycopy(storage, position, storage, position - 1, size - position);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
