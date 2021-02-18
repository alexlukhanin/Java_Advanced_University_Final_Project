/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 * <p>
 * Interface ua.uz.alex.university.dto.FacultyDtoHelper  - dto layer
 *
 * @author Oleksandr Lukhanin
 */


package ua.uz.alex.university.dto;

import org.springframework.web.multipart.MultipartFile;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.Subject;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class FacultyDtoHelper {

    public static Faculty createEntity(MultipartFile file,
                                       String name,
                                       Integer numberOfStudents,
                                       List<Subject> subjects) throws IOException {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setNumberOfStudents(numberOfStudents);
        faculty.setSubjects(subjects);
        faculty.setLogo(Base64.getEncoder().encodeToString(file.getBytes()));
        return faculty;
    }


}
