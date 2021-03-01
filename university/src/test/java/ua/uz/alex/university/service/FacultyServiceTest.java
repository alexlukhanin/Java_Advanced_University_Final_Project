package ua.uz.alex.university.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.uz.alex.university.dao.FacultyRepository;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.Subject;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.domain.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class FacultyServiceTest {
    @Autowired
    private FacultyService service;

    @MockBean
    private FacultyRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Subject1"));
        subjects.add(new Subject("Subject2"));
        subjects.add(new Subject("Subject3"));

        Faculty faculty = new Faculty(1, "faculty1", 45, subjects);
        doReturn(Optional.of(faculty)).when(repository).findById(1);
        Optional<Faculty> returnedFaculty= service.findById(1);
        // Assert the response
        Assertions.assertTrue(returnedFaculty.isPresent(), "Faculty was not found");
        Assertions.assertSame(returnedFaculty.get(), faculty, "The faculty returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {

        doReturn(Optional.empty()).when(repository).findById(1);
        Optional<Faculty> returnedFaculty = service.findById(1);
        // Assert the response
        Assertions.assertFalse(returnedFaculty.isPresent(), "Faculty should not be found");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(new Subject("Subject1"));
        subjects1.add(new Subject("Subject2"));
        subjects1.add(new Subject("Subject3"));

        List<Subject> subjects2 = new ArrayList<>();
        subjects2.add(new Subject("Subject1"));
        subjects2.add(new Subject("Subject2"));
        subjects2.add(new Subject("Subject4"));

         Faculty faculty1 = new Faculty(1, "faculty1", 45, subjects1);
         Faculty faculty2= new Faculty(2, "faculty2", 55, subjects2);
        doReturn(Arrays.asList(faculty1, faculty2)).when(repository).findAll();
        List<Faculty> faculties = service.getAllFaculties();
        // Assert the response
        Assertions.assertEquals(2, faculties.size(), "findAll should return 2 faculties");
    }

    @Test
    @DisplayName("Test save faculty")
    void testSave() {
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(new Subject("Subject1"));
        subjects1.add(new Subject("Subject2"));
        subjects1.add(new Subject("Subject3"));

        Faculty faculty1 = new Faculty(1, "faculty1", 45, subjects1);
        doReturn(faculty1).when(repository).save(any());
        Faculty returnedFaculty = service.save(faculty1);
        // Assert the response
        Assertions.assertNotNull(returnedFaculty, "The saved faculty should not be null");
    }

    @Test
    @DisplayName("Test delete faculty")
    void testDelete() {
        List<Subject> subjects1 = new ArrayList<>();
        subjects1.add(new Subject("Subject1"));
        subjects1.add(new Subject("Subject2"));
        subjects1.add(new Subject("Subject3"));
        Faculty faculty1 = new Faculty(1, "faculty1", 45, subjects1);
        service.save(faculty1);
        service.deleteById(0);
        // Assert the response
        Assertions.assertEquals(0, service.getAllFaculties().size(),"The number of faculties should be null");
    }
}
