package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.uz.alex.university.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
