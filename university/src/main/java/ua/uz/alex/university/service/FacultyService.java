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
import java.util.Optional;

public interface FacultyService {
    public Faculty save(Faculty faculty);
    public List<Faculty> getAllFaculties();
    public Optional<Faculty> findById(Integer id);
    public void deleteById(Integer id);
}
