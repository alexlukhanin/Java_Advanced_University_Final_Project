package ua.uz.alex.university.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;


public interface FileService {

    public String saveFileAndReturnPathForDB(MultipartFile multipartFile , String filename) throws IOException;

}
