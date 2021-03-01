/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Interface ua.uz.alex.university.service.UserService  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service;

import ua.uz.alex.university.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService{
    public User save(User user) ;
    public Optional<User> findByEmail(String email);
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public void deleteById(Integer id);

}