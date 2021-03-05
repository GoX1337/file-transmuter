package com.gox.file.transmuter.controller;

import com.gox.file.transmuter.cache.CacheService;
import com.gox.file.transmuter.data.FileObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FileController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/file")
    public Map<String, List<FileObject>> getAllFiles(){
        return cacheService.getAll();
    }
}
