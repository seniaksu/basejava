package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.ObjectStreamSerializer;

public class FileStreamStorageTest extends AbstractStorageTest {
    public FileStreamStorageTest() {
        super(new FileStreamStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}