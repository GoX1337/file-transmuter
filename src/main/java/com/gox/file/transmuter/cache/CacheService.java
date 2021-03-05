package com.gox.file.transmuter.cache;

import com.gox.file.transmuter.data.FileObject;

import java.util.List;
import java.util.Map;

public interface CacheService {

    void save(String fileName, List<FileObject> fo);

    List<FileObject> load(String fileName);

    Map<String, List<FileObject>> getAll();

}
