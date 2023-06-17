package com.api.book.bootrestbook.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

//    private final String UPLOAD_DIR="C:\\D-drive-Workspace\\springbootproject\\bootrestbook\\src\\main\\resources\\static\\images";
      private final String UPLOAD_DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath();

      public FileUploadHelper() throws IOException {
      }

    public boolean uploadFile(MultipartFile multipartFile){

        boolean f=false;

        try {

            //OLD Ways to read and write data via stream api
//            //read data
//            InputStream inputStream = multipartFile.getInputStream();
//            byte data[] = new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //write data to upload_dir
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//            fileOutputStream.write(data);
//
//            fileOutputStream.flush();
//            fileOutputStream.close();


            //another way to read and write via nio -> Files.copy(input, path, copy option)
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return f;
    }

}
