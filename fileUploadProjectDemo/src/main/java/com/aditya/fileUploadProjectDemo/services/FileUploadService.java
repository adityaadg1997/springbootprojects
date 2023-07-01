package com.aditya.fileUploadProjectDemo.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileUploadService {
    String fileUpload(String path, MultipartFile file) throws IOException;

    InputStream getResource(String path, String imageName) throws FileNotFoundException;
}
