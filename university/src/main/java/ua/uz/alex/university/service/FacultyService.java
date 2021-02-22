/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.FacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.FacultyRepository;
import ua.uz.alex.university.domain.Faculty;

import java.util.List;

public interface FacultyService {
    public void save(Faculty faculty);
    public List<Faculty> getAllFaculties();
    public Faculty findById(Integer id);
}
