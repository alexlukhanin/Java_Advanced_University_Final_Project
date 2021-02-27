/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.controller.RegistrationController  - controller layer
 * names of faculties in university (as example threre almoust all faculties of Uzhhorod National University)
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.RegistrationForFaculty;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.mapper.RegistrationForFacultyDtoMapper;
import ua.uz.alex.university.service.FacultyService;
import ua.uz.alex.university.service.RegistrationForFacultyService;
import ua.uz.alex.university.service.UserService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegistrationForFacultyController {

    @Autowired
    private UserService userService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private RegistrationForFacultyService registrationForFacultyService;

    @Autowired
    private RegistrationForFacultyDtoMapper registrationForFacultyDtoMapper;

    @GetMapping("/faculty_reg")
    public ModelAndView registerForFaculty(@RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
        Faculty faculty = facultyService.findById(id);
        User user = userService.findByEmail(email);
        RegistrationForFaculty registrationForFaculty = new RegistrationForFaculty();
        registrationForFaculty.setFaculty(faculty);
        registrationForFaculty.setUser(user);
        ModelAndView modelAndView = new ModelAndView("registrationForTheFaculty");
        modelAndView.addObject("registrationForFaculty", registrationForFaculty);
        modelAndView.addObject("currentUser", user);
        return modelAndView;
    }

    @PostMapping("/faculty_reg")
    public ModelAndView addRegistration(@Valid @ModelAttribute("registrationForFaculty") RegistrationForFaculty registrationForFaculty,
                                        @RequestParam MultipartFile userPhoto,
                                        @RequestParam MultipartFile documentPhoto,
                                        BindingResult bindingResult) throws IOException {
        Faculty faculty = facultyService.findById(registrationForFaculty.getFacultyId());
        User user = userService.findByEmail(registrationForFaculty.getEmail());
        registrationForFaculty.setFaculty(faculty);
        registrationForFaculty.setUser(user);
        RegistrationForFaculty entity = registrationForFacultyDtoMapper.createEntity(userPhoto,
                documentPhoto, faculty, user, registrationForFaculty.getMarks());
        entity.setSumMarks(registrationForFaculty.getMarks().stream().reduce(0, Integer::sum));
        registrationForFacultyService.save(entity);
        return new ModelAndView("redirect:/home");
    }

}
