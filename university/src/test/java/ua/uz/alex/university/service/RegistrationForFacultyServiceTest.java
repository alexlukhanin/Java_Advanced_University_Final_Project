package ua.uz.alex.university.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.uz.alex.university.dao.RegistrationForFacultyRepository;
import ua.uz.alex.university.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class RegistrationForFacultyServiceTest {
    @Autowired
    private RegistrationForFacultyService service;

    @MockBean
    private RegistrationForFacultyRepository repository;


    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        User user1 = new User(0, "new@new1", "new", "user", UserRole.ROLE_USER, "1");
        User user2 = new User(1, "new@new2", "new", "user", UserRole.ROLE_USER, "1");
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Subject1"));
        subjects.add(new Subject("Subject2"));
        subjects.add(new Subject("Subject3"));
        Faculty faculty = new Faculty(1, "faculty1", 45, subjects);
        List<Integer> marks = new ArrayList<>();
        marks.add(180);
        marks.add(189);
        marks.add(188);
        List<Integer> marks1 = new ArrayList<>();
        marks.add(150);
        marks.add(180);
        marks.add(195);
         RegistrationForFaculty registration1 = new RegistrationForFaculty( faculty, user1, marks);
         RegistrationForFaculty registration2 = new RegistrationForFaculty( faculty, user2, marks1);

        doReturn(Arrays.asList(registration1, registration2)).when(repository).findAll();
        List<RegistrationForFaculty> registrationForFacultyList = service.showAllEntrants();
        // Assert the response
        Assertions.assertEquals(2, registrationForFacultyList.size(), "findAll should return 2 registrations");
    }

    @Test
    @DisplayName("Test save faculty")
    void testSave() {
        User user1 = new User(0, "new@new1", "new", "user", UserRole.ROLE_USER, "1");
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Subject1"));
        subjects.add(new Subject("Subject2"));
        subjects.add(new Subject("Subject3"));
        Faculty faculty = new Faculty(1, "faculty1", 45, subjects);
        List<Integer> marks = new ArrayList<>();
        marks.add(180);
        marks.add(189);
        marks.add(188);
        RegistrationForFaculty registrationForFaculty = new RegistrationForFaculty( faculty, user1, marks);
        doReturn(registrationForFaculty).when(repository).save(any());
        RegistrationForFaculty returnedRegistration = service.save(registrationForFaculty);
        // Assert the response
        Assertions.assertNotNull(returnedRegistration, "The saved registration should not be null");
    }

}
