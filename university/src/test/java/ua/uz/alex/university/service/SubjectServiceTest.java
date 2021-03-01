package ua.uz.alex.university.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.uz.alex.university.dao.FacultyRepository;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService service;

    @MockBean
    private SubjectRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {

        Subject subject = new Subject("Subject1");
        doReturn(Optional.of(subject)).when(repository).findById(0);
        Optional<Subject> returnedSubject= service.findById(0);
        // Assert the response
        Assertions.assertTrue(returnedSubject.isPresent(), "Subject was not found");
        Assertions.assertSame(returnedSubject.get(), subject, "The subject returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {

        doReturn(Optional.empty()).when(repository).findById(1);
        Optional<Subject> returnedSubject = service.findById(1);
        // Assert the response
        Assertions.assertFalse(returnedSubject.isPresent(), "Subject should not be found");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {

         Subject subject1 = new Subject( "subject1");
         Subject subject2 = new Subject( "subject2");

        doReturn(Arrays.asList(subject1, subject2)).when(repository).findAll();
        List<Subject> subjects = service.findAll();
        // Assert the response
        Assertions.assertEquals(2, subjects.size(), "findAll should return 2 subjects");
    }

    @Test
    @DisplayName("Test save faculty")
    void testSave() {


        Subject subject1 = new Subject( "subject1");
        doReturn(subject1).when(repository).save(any());
        Subject returnedSubject = service.save(subject1);
        // Assert the response
        Assertions.assertNotNull(returnedSubject, "The saved subject should not be null");
    }

//    @Test
//    @DisplayName("Test delete faculty")
//    void testDelete() {
//        List<Subject> subjects1 = new ArrayList<>();
//        subjects1.add(new Subject("Subject1"));
//        subjects1.add(new Subject("Subject2"));
//        subjects1.add(new Subject("Subject3"));
//        Faculty faculty1 = new Faculty(1, "faculty1", 45, subjects1);
//        service.save(faculty1);
//        service.deleteById(0);
//        // Assert the response
//        Assertions.assertEquals(0, service.getAllFaculties().size(),"The number of faculties should be null");
//    }
}
