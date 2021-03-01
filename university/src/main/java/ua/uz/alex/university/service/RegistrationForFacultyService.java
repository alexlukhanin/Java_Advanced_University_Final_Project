/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.service.RegistrationForFacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import ua.uz.alex.university.domain.RegistrationForFaculty;
import java.util.List;

public interface RegistrationForFacultyService {

    public RegistrationForFaculty save(RegistrationForFaculty facultyRegistration);
    public List<RegistrationForFaculty> showAllEntrants();
}
