package com.aditya.fileUploadProjectDemo.controllers;

import com.aditya.fileUploadProjectDemo.payloads.FileResponse;
import com.aditya.fileUploadProjectDemo.services.FileUploadService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("file") MultipartFile file){

        String fileName = null;

        try {
             fileName = this.fileUploadService.fileUpload(path, file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponse("file is Not uploaded !!", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse("file is successfully uploaded !!", fileName), HttpStatus.OK);
    }

    //serve the file
    @GetMapping("/profile/{imageName}")
    public void downloadImage(@PathVariable("imageName") String imageName,
                              HttpServletResponse response) throws IOException {
        InputStream resource = this.fileUploadService.getResource(path, imageName);

        response.setContentType(MediaType.ALL_VALUE);

        StreamUtils.copy(resource, response.getOutputStream());
    }
}
