/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.SubjectServiceImpl  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.domain.Subject;
import ua.uz.alex.university.service.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Autowired
    private SubjectRepository subjectRepository;

    public void save(Subject subject) {
        logger.info("Create(save) subject{}: " + subject);
        subjectRepository.save(subject);
    }

    public List<Subject> getAllFaculties() {
        logger.info("Get all faculties(List)");
        return subjectRepository.findAll();
    }

    public Subject findById(Integer id) {
        logger.info("Find subject{} by id (" + id + ")");
        return subjectRepository.findById(id).get();
    }
}
