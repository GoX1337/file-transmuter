package com.gox.file.transmuter.parser;

import com.gox.file.transmuter.data.FileObject;
import de.siegmar.fastcsv.reader.NamedCsvReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CsvFileParser implements FileParser {

    public List<FileObject> parse(MultipartFile file) {
        try {
            Reader reader = new InputStreamReader(file.getInputStream());
            return NamedCsvReader
                    .builder()
                    .build(reader)
                    .stream()
                    .map(row -> new FileObject(row.getFields()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}