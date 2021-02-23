/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 * <p>
 * Interface ua.uz.alex.university.mapper.FacultyDtoMapper  - dto layer
 *
 * @author Oleksandr Lukhanin
 */


package ua.uz.alex.university.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.RegistrationForFaculty;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.service.FileService;

import java.io.IOException;
import java.util.List;

@Controller
public class RegistrationForFacultyDtoMapper {

    @Autowired
    private FileService fileService;

    public RegistrationForFaculty createEntity(MultipartFile filePhoto,
                                               MultipartFile fileDocument,
                                               Faculty faculty,
                                               User user,
                                               List<Integer> marks) throws IOException {

        RegistrationForFaculty registrationForFaculty = new RegistrationForFaculty();
//        List<String> collect = subjects.stream().map(subject -> subject.getName()).collect(Collectors.toList());
//        List<Subject> allByNameLike = subjectRepository.getAllByNameIn(collect);
//        mapSubjects(subjects , allByNameLike);
        registrationForFaculty.setFaculty(faculty);
        registrationForFaculty.setUser(user);
        registrationForFaculty.setMarks(marks);
        registrationForFaculty.setUploadPhoto(fileService.saveFile(filePhoto , user.getFirstName() +
                "_" + user.getLastName() + "_photo"));
        registrationForFaculty.setUploadDocument(fileService.saveFile(fileDocument , user.getFirstName() +
                "_" + user.getLastName() + "_document"));

      //  faculty.setLogoUrl(fileService.saveFile(filePhoto , user.getFirstName() + "_" + user.getLastName()));

        return registrationForFaculty;
    }

//    private void mapSubjects(List<Subject> needSubjects , List<Subject> existSubjects){
//
//        for (Subject needSubject : needSubjects) {
//            for (Subject existSubject : existSubjects) {
//                if (needSubject.getName().equalsIgnoreCase(existSubject.getName())){
//                    needSubject.setId(existSubject.getId());
//                }
//            }
//        }
//
//    }


}
