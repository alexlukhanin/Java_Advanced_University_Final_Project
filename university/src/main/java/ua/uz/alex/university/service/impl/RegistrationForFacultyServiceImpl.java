/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.RegistrationForFacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.RegistrationForFacultyRepository;
import ua.uz.alex.university.domain.RegistrationForFaculty;
import ua.uz.alex.university.service.RegistrationForFacultyService;

import java.util.List;

@Service
public class RegistrationForFacultyServiceImpl implements RegistrationForFacultyService {
    @Autowired
    private RegistrationForFacultyRepository registrationForFacultyRepository;

    public void save(RegistrationForFaculty facultyRegistration) {
        registrationForFacultyRepository.save(facultyRegistration);
    }

    public List<RegistrationForFaculty> showAllEntrants() {
        return registrationForFacultyRepository.findAll();
    }
}
