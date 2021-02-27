/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.dao.RegistrationForFacultyRepository  - dao layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.uz.alex.university.domain.RegistrationForFaculty;

import java.util.List;

@Repository
public interface RegistrationForFacultyRepository extends JpaRepository<RegistrationForFaculty, Integer> {

    //List<RegistrationForFaculty> findByOrderBySumMarksAsc();
}
