/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.FacultyService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.FacultyRepository;
import ua.uz.alex.university.domain.Faculty;
import ua.uz.alex.university.service.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    private Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    @Autowired
    private FacultyRepository facultyRepository;
    public void save(Faculty faculty) {
        logger.info("Save faculty {}: " + faculty);
        facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        logger.info("Get all faculties");
        return facultyRepository.findAll();
    }

    public Faculty findById(Integer id) {

        logger.info("Find faculty by id (" + id + ")");
        return facultyRepository.findById(id).get();
    }
}