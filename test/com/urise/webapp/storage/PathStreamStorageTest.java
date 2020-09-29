package com.urise.webapp.storage;


import com.urise.webapp.storage.serialization.ObjectStreamSerializer;

public class PathStreamStorageTest extends AbstractStorageTest {
    public PathStreamStorageTest() {
        super(new PathStreamStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}

