/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.UserService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.domain.UserRole;

public interface UserService{
    public void save(User user) ;
    public User findByEmail(String email);
}