package ua.uz.alex.university;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.uz.alex.university.dao.FacultyRepository;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.service.FacultyService;
import ua.uz.alex.university.service.RegistrationForFacultyService;
import ua.uz.alex.university.service.SubjectService;
import ua.uz.alex.university.service.UserService;


@SpringBootTest
public class UniversityApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private RegistrationForFacultyService registrationForFacultyService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectRepository subjectRepository;


	@Test
	public void isUserSaveToDataBase() {

//		List<User> users = userRepository.findAll();
//		int usersSize = users.size();
//		assertThat(users, hasSize(usersSize));
//
//		User user = new User();
//		user.setEmail("11@gmail.com");
//		user.setFirstName("name");
//		user.setLastName("surname1");
//		user.setPassword("11");
//		user.setPasswordConfirm("11");
//		user.setRole(UserRole.ROLE_USER);
//
//		userService.save(user);
//
//		users = userRepository.findAll();
//		assertThat(users, hasSize(usersSize + 1));

//		User userFromDb = users.get(0);
//		assertTrue(userFromDb.getEmail().equals(user.getEmail()));
//		assertTrue(userFromDb.getFirstName().equals(user.getFirstName()));
//		assertTrue(userFromDb.getLastName().equals(user.getLastName()));
//		assertTrue(userFromDb.getRole().equals(user.getRole()));



	}




}
