/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.service.SubjectService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import ua.uz.alex.university.domain.Subject;

import java.util.List;

public interface SubjectService {
    public void save(Subject subject);
    public List<Subject> getAllFaculties();
    public Subject findById(Integer id);
}
