/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.service.FacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import ua.uz.alex.university.domain.Faculty;
import java.util.List;

public interface FacultyService {
    public void save(Faculty faculty);
    public List<Faculty> getAllFaculties();
    public Faculty findById(Integer id);
}
