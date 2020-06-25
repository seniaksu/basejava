package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void SaveElement(int index, Resume r) {
        //Метод Arrays.binarySearch() возвращает позицию заданного значения.
        // Если элемент не найден, то возвращается - (position + 1),
        //где position - позиция элемента где он мог бы быть
        System.arraycopy(storage, -index - 1, storage, -index, size + index + 1);
        storage[-index - 1] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
