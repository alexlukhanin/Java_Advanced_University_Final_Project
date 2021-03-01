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
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}




}
