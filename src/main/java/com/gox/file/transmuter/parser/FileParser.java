package com.gox.file.transmuter.parser;

import com.gox.file.transmuter.data.FileObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileParser {

    List<FileObject> parse(MultipartFile file);

}
