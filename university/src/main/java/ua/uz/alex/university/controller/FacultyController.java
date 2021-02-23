/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.controller.FacultyController - controller layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.domain.Subject;
import ua.uz.alex.university.mapper.FacultyDtoMapper;
import ua.uz.alex.university.service.FacultyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private FacultyDtoMapper facultyDtoMapper;

    @PostMapping("/add_faculty")
    public ModelAndView createFaculty (
            @RequestParam MultipartFile facultyLogo,
            @RequestParam String facultyName,
            @RequestParam Integer numberOfStudents,
            @RequestParam String firstSubject,
            @RequestParam String secondSubject,
            @RequestParam String thirdSubject
            ) throws IOException {

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(firstSubject));
        subjects.add(new Subject(secondSubject));
        subjects.add(new Subject(thirdSubject));

        facultyService.save(facultyDtoMapper.createEntity(facultyLogo, facultyName,
                numberOfStudents, subjects));
        return new ModelAndView("redirect:/admin_panel");
    }

    @GetMapping("/admin_panel")
    public String getAdminPanel(Model model){
        List<Faculty> allFaculties = facultyService.getAllFaculties();
        model.addAttribute("faculties" , allFaculties);
        model.addAttribute("subjects" , subjectRepository.findAll());
        return "admin_panel";
    }


}
