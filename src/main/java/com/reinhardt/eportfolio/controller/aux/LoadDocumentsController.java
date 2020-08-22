package com.reinhardt.eportfolio.controller.aux;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.PathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LoadDocumentsController {

    @GetMapping(value="/getDocument",produces = "application/pdf")
    public ResponseEntity<InputStreamResource> getDocument(@RequestParam String documentName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + documentName);
        PathResource pdfFile = new PathResource("/" + documentName);
        ResponseEntity<InputStreamResource> response = null;
        try {
            response = new ResponseEntity<>(
                    new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
