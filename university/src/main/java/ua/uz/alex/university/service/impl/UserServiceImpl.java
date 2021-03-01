/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.service.UserServiceImpl  - service layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.domain.UserRole;
import ua.uz.alex.university.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      //  user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
        user.setRole(UserRole.ROLE_USER);
        logger.info("Create(save) new user{}: " + user);

        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        logger.info("Find user{} by email (" + email + ")");
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Integer id) {
        logger.info("Find user by id (" + id + ")");
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}