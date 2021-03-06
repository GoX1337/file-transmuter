package com.gox.file.transmuter.parser;

import com.gox.file.transmuter.data.FileObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class CsvFileParser implements FileParser {

    public List<FileObject> parse(MultipartFile file){
        List<FileObject> csvFile = new ArrayList<>();
        try {
            InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String headerLine = br.readLine();
            List<String> headerValues = null;
            if(headerLine != null){
                headerValues = Arrays.asList(headerLine.split(";"));
            }

            String line;
            while ((line = br.readLine()) != null) {

                if(line.isBlank() || line.isEmpty()){
                    continue;
                }

                FileObject csvObj = new FileObject();
                List<String> lineValues = Arrays.asList(line.split(";"));
                if(lineValues.size() != headerValues.size()){
                    log.info("Problem parsing line: {}", line);
                    continue;
                }

                for(int i = 0; i < headerValues.size(); i++){
                    csvObj.addAttribute(headerValues.get(i), lineValues.get(i));
                }
                csvFile.add(csvObj);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return csvFile;
    }

}