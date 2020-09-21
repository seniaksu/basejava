package com.urise.webapp.storage;


import com.urise.webapp.storage.serialization.ObjectStreamStorage;

public class PathStreamStorageTest extends AbstractStorageTest {
    public PathStreamStorageTest() {
        super(new PathStreamStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamStorage()));
    }
}

