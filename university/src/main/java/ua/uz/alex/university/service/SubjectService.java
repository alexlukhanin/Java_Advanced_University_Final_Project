package ua.uz.alex.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.SubjectRepository;
import ua.uz.alex.university.domain.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService {
    public void save(Subject subject);
    public List<Subject> getAllFaculties();
    public Subject findById(Integer id);
}
