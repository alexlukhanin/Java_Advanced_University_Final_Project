/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.FacultyServiceImpl  - service layer
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
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    private Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    @Autowired
    private FacultyRepository facultyRepository;
    public Faculty save(Faculty faculty) {
        logger.info("Save faculty {}: " + faculty);
       return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        logger.info("Get all faculties");
        return facultyRepository.findAll();
    }

    public Optional<Faculty> findById(Integer id) {

        logger.info("Find faculty by id (" + id + ")");
        return facultyRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("Delete faculty by id (" + id + ")");
        facultyRepository.deleteById(id);
    }
}
