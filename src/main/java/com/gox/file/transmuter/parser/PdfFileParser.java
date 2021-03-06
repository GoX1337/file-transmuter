package com.gox.file.transmuter.parser;

import com.gox.file.transmuter.data.FileObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class PdfFileParser implements FileParser {

    @Override
    public List<FileObject> parse(MultipartFile file) {

        try (PDDocument document = PDDocument.load(file.getInputStream())){
            String text = new PDFTextStripper().getText(document);
            System.out.println("Text in PDF\n---------------------------------");
            System.out.println(text);
        } catch (IOException e) {
            log.error("error ", e.getMessage());
        }
        return null;
    }
}
