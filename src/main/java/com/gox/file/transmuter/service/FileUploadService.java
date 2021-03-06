package com.gox.file.transmuter.service;

import com.gox.file.transmuter.cache.CacheService;
import com.gox.file.transmuter.data.FileObject;
import com.gox.file.transmuter.parser.CsvFileParser;
import com.gox.file.transmuter.parser.PdfFileParser;
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

    @Autowired
    private PdfFileParser pdfFileParser;

    public List<FileObject> saveFileObject(String name, MultipartFile file){
        List<FileObject> fileObjects = null;

        if(name.endsWith(".csv")){
            fileObjects = csvFileParser.parse(file);
        } else if(name.endsWith(".pdf")){
            fileObjects = pdfFileParser.parse(file);
        }

        if(fileObjects != null) {
            cacheService.save(name, fileObjects);
        }
        return fileObjects;
    }
}
