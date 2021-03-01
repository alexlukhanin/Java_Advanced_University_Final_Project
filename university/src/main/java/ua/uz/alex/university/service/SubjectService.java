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
import java.util.Optional;

public interface SubjectService {
    public Subject save(Subject subject);
    public List<Subject> findAll();
    public Optional<Subject> findById(Integer id);
}
