package com.project.BlogApp.service.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.project.BlogApp.service.FileService;

@Service
public class FileImpl implements FileService {


    
    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        // 1.file name
        // 2.create folder
        // 3.copy file

        String fileName = file.getOriginalFilename();

        String filePath = path + File.separator + fileName;


        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.mkdir();
        }


        try {
            Files.copy(file.getInputStream(),Paths.get(filePath),StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(filePath);
        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String filePath = path + File.separator + fileName;
        InputStream is = new FileInputStream(filePath);
        return is;
    }
    
}
