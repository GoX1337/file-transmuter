package com.gox.file.transmuter.service;

import com.gox.file.transmuter.cache.CacheService;
import com.gox.file.transmuter.data.FileObject;
import com.gox.file.transmuter.parser.CsvFileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CsvFileParser csvFileParser;

    public List<FileObject> saveFileObject(String name, MultipartFile file){
        List<FileObject> fileObjects = null;

        if(name.endsWith(".csv")){
            fileObjects = csvFileParser.parse(file);
        }

        if(fileObjects != null) {
            cacheService.save(name, fileObjects);
        }
        return fileObjects;
    }
}
