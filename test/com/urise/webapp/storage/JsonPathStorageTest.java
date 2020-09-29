package com.urise.webapp.storage;

import com.urise.webapp.storage.serialization.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest{
    public JsonPathStorageTest() {
        super(new PathStreamStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}
