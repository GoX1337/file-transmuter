package com.gox.file.transmuter.cache.impl;

import com.gox.file.transmuter.cache.CacheService;
import com.gox.file.transmuter.data.FileObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadCacheService implements CacheService {

    private Map<String, List<FileObject>> files = new HashMap<>();

    @Override
    public void save(String fileName, List<FileObject> fo) {
        files.put(fileName, fo);
    }

    @Override
    public List<FileObject> load(String fileName) {
        return files.get(fileName);
    }

    @Override
    public Map<String, List<FileObject>> getAll() {
        return files;
    }
}
