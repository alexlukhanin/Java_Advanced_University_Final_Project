/**
 * The Final project on "Java Developer" Course in LOGOS IT Academy
 * University portal (Admissions Committee)
 *
 * Class ua.uz.alex.university.security.CustomUserDetailsService - security layer
 *
 * @author Oleksandr Lukhanin
 *
 */

package ua.uz.alex.university.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.domain.User;

import java.util.Collections;
import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
        }
        throw new UsernameNotFoundException("No user present with useremail:" + email);
    }
}