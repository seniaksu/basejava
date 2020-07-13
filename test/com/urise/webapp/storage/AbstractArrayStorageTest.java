package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final Resume r1 = new Resume("uuid1");
    private static final Resume r2 = new Resume("uuid2");
    private static final Resume r3 = new Resume("uuid3");
    private static final Resume r4 = new Resume("uuid4");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(r1);
        storage.save(r2);
        storage.save(r3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r5 = new Resume("uuid2");
        storage.update(r5);
        assertEquals(r5, storage.get("uuid2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] result = storage.getAll();
        assertArrayEquals(storage.getAll(), result);
    }

    @Test
    public void save() throws Exception {
        storage.save(r4);
        assertEquals(r4, storage.get("uuid4"));
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(r1);
    }

    @Test(expected = StorageException.class)
    public void overflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException ex) {
            ex.getMessage();
        }
        storage.save(new Resume());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete("uuid2");
        assertEquals(2, storage.size());
        storage.get("uuid2");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertEquals(r1, storage.get("uuid1"));
        assertEquals(r2, storage.get("uuid2"));
        assertEquals(r3, storage.get("uuid3"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}