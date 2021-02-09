/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.controller.EntrantsController  - controller layer
 * names of faculties in university (as example threre almoust all faculties of Uzhhorod National University)
 *
 * @author Oleksandr Lukhanin
 *
 */


package ua.uz.alex.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.uz.alex.university.service.RegistrationForFacultyService;

@Controller
public class EntrantsController {

    @Autowired
    private RegistrationForFacultyService registrationForFacultyService;

    @GetMapping("/show-entrants")
    public ModelAndView showAllEntrants() {
        return new ModelAndView("showRegistrations", "facultyRegistrations",
                registrationForFacultyService.showAllEntrants());
    }


}
