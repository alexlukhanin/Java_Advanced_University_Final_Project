package ua.uz.alex.university.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ua.uz.alex.university.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;

@Component
public class FileServiceImpl implements FileService {

    public String saveFile(MultipartFile multipartFile , String filename) throws IOException {

        String pathStartPart =  "src/main/webapp/";
        String pathSecondPart = "imageDB/faculty/";
        String pathToDB = pathSecondPart + filename + "/" + new Date().getTime() + multipartFile.getOriginalFilename();
        String filePathToFileSystem = pathStartPart + pathToDB;

        Path target = Paths.get(filePathToFileSystem);
        Files.createDirectories(target);
        Files.copy(multipartFile.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        return pathToDB;
    }


}
