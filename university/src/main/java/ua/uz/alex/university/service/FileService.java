/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.service.FileService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public interface FileService {

    public String saveFileAndReturnPathForDB(MultipartFile multipartFile , String filename) throws IOException;

}
