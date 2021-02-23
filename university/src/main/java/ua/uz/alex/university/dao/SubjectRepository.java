/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.dao.SubjectRepository  - dao layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.uz.alex.university.domain.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> getAllByNameIn(List<String> strings);
}
