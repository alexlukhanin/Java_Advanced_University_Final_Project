/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 * <p>
 * Interface ua.uz.alex.university.mapper.FacultyDtoMapper  - dto layer
 *
 * @author Oleksandr Lukhanin
 */


package ua.uz.alex.university.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.Subject;
import ua.uz.alex.university.service.FileService;
import ua.uz.alex.university.service.impl.FacultyServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FacultyDtoMapper {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private FileService fileService;

    public Faculty createEntity(MultipartFile file,
                                String name,
                                Integer numberOfStudents,
                                List<Subject> subjects) throws IOException {

        Faculty faculty = new Faculty();
        List<String> collect = subjects.stream().map(subject -> subject.getName()).collect(Collectors.toList());
        List<Subject> allByNameLike = subjectRepository.getAllByNameIn(collect);
        mapSubjects(subjects , allByNameLike);
        faculty.setName(name);
        faculty.setNumberOfStudents(numberOfStudents);
        faculty.setLogoUrl(fileService.saveFileAndReturnPathForDB(file , faculty.getName()));
        faculty.setSubjects(subjects);

        return faculty;
    }

    private void mapSubjects(List<Subject> needSubjects , List<Subject> existSubjects){

        for (Subject needSubject : needSubjects) {
            for (Subject existSubject : existSubjects) {
                if (needSubject.getName().equalsIgnoreCase(existSubject.getName())){
                    needSubject.setId(existSubject.getId());
                }
            }
        }

    }


}
