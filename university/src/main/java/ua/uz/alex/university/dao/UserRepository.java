/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.dao.UserRepository  - dao layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.uz.alex.university.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
