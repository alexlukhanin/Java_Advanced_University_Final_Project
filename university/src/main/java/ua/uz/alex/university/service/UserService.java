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

public interface UserService{
    public void save(User user) ;
    public User findByEmail(String email);
}