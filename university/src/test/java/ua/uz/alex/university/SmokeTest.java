package ua.uz.alex.university;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.uz.alex.university.controller.EntrantsController;
import ua.uz.alex.university.controller.FacultyController;
import ua.uz.alex.university.controller.RegistrationForFacultyController;
import ua.uz.alex.university.controller.UserController;


@SpringBootTest
public class SmokeTest {

	@Autowired
	private EntrantsController entrantsController;
	@Autowired
	private FacultyController facultyController;
	@Autowired
	private RegistrationForFacultyController registrationForFacultyController;
	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(entrantsController).isNotNull();
		assertThat(facultyController).isNotNull();
		assertThat(registrationForFacultyController).isNotNull();
		assertThat(userController).isNotNull();
	}
}
