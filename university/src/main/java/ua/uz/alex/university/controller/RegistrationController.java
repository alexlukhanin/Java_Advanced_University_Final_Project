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
import org.springframework.web.servlet.ModelAndView;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.RegistrationForFaculty;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.service.FacultyService;
import ua.uz.alex.university.service.RegistrationForFacultyService;
import ua.uz.alex.university.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private RegistrationForFacultyService registrationForFacultyService;

    @GetMapping("/register-for-faculty")
    public ModelAndView registerForFaculty(@RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
        Faculty faculty = facultyService.findById(id);
        User user = userService.findByEmail(email);
        RegistrationForFaculty registrationForFaculty = new RegistrationForFaculty();
        registrationForFaculty.setFaculty(faculty);
        registrationForFaculty.setUser(user);
        ModelAndView modelAndView = new ModelAndView("registerForFaculty");
        modelAndView.addObject("facultyRegistration", registrationForFaculty);
        return modelAndView;
    }

    @PostMapping("/register-for-faculty")
    public ModelAndView addRegistration(@Valid @ModelAttribute("facultyRegistration") RegistrationForFaculty registrationForFaculty,
                                        BindingResult bindingResult) {
        Faculty faculty = facultyService.findById(registrationForFaculty.getFacultyId());
        User user = userService.findByEmail(registrationForFaculty.getEmail());
        registrationForFaculty.setFaculty(faculty);
        registrationForFaculty.setUser(user);
        registrationForFacultyService.save(registrationForFaculty);
        return new ModelAndView("redirect:/home");
    }

}
