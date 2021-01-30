package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.uz.alex.university.domain.Faculty;

public interface FacultyRepository extends JpaRepository <Faculty, Integer> {

}
