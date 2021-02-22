/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.RegistrationForFacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.RegistrationForFacultyRepository;
import ua.uz.alex.university.domain.RegistrationForFaculty;

import java.util.List;

public interface RegistrationForFacultyService {

    public void save(RegistrationForFaculty facultyRegistration);
    public List<RegistrationForFaculty> showAllEntrants();
}
