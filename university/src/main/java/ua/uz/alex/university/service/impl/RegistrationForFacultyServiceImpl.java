/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.RegistrationForFacultyServiceImpl  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.RegistrationForFacultyRepository;
import ua.uz.alex.university.domain.RegistrationForFaculty;
import ua.uz.alex.university.service.RegistrationForFacultyService;

import java.util.List;

@Service
public class RegistrationForFacultyServiceImpl implements RegistrationForFacultyService {
    private Logger logger = LoggerFactory.getLogger(RegistrationForFacultyServiceImpl.class);

    @Autowired
    private RegistrationForFacultyRepository registrationForFacultyRepository;

    public RegistrationForFaculty save(RegistrationForFaculty facultyRegistration) {

        logger.info("Create new registration for faculty{}: " + facultyRegistration);
        return registrationForFacultyRepository.save(facultyRegistration);
    }

    public List<RegistrationForFaculty> showAllEntrants() {
        logger.info("Get all Entrants(registrations)");
        return registrationForFacultyRepository.findAll();
    }
}
