package com.aditya.fileUploadProjectDemo.services.impl;

import com.aditya.fileUploadProjectDemo.services.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String fileUpload(String path, MultipartFile file) throws IOException {

        //file name
        String fileName = file.getOriginalFilename();

        //generate random file name
        String randomID = UUID.randomUUID().toString();
        String randomFileName = randomID.concat(fileName.substring(fileName.lastIndexOf("."))); //it will extract string from . like .png .jpg

        //full path
        String fullPath = path + File.separator + randomFileName;

        //create folder
       File folder = new File(path);
       if(!folder.exists()){
           folder.mkdir();
       }


        //upload code
        Files.copy(file.getInputStream(), Paths.get(fullPath));


        return randomFileName;
    }

    //serve file
    @Override
    public InputStream getResource(String path, String imageName) throws FileNotFoundException {

        String fullPath = path+File.separator+imageName;

        InputStream inputStream = new FileInputStream(fullPath);

        return inputStream;
    }
}
