package com.gox.file.transmuter.controller;

import com.gox.file.transmuter.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class FileImportController {

    @Autowired
    private FileUploadService fileUploadService;


    @PostMapping("/file")
    public String csvFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        String filename = file.getOriginalFilename();
        log.info("File uploaded : {}", filename);
        boolean isSaved = fileUploadService.saveFileObject(filename, file);
        String msg = isSaved ? "You successfully uploaded " + filename + "!" : "File type not supported";
        redirectAttributes.addFlashAttribute("message", msg);
        return "redirect:/";
    }
}
