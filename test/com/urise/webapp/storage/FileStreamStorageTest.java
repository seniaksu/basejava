package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.ObjectStreamStorage;

public class FileStreamStorageTest extends AbstractStorageTest {
    public FileStreamStorageTest() {
        super(new FileStreamStorage(STORAGE_DIR, new ObjectStreamStorage()));
    }
}