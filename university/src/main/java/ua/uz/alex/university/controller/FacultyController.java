package ua.uz.alex.university.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.uz.alex.university.domain.Subject;
import ua.uz.alex.university.dto.FacultyDtoHelper;
import ua.uz.alex.university.service.FacultyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    FacultyService facultyService;

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

        facultyService.save(FacultyDtoHelper.createEntity(facultyLogo, facultyName,
                numberOfStudents, subjects));
       // System.out.println("add_faculty is Done ");
        //subjects.stream().forEach(System.out::println);
        return new ModelAndView("redirect:/admin_panel");
    }


}
