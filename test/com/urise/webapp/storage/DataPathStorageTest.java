package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.DataStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {

    public DataPathStorageTest() {
        super(new PathStreamStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}
