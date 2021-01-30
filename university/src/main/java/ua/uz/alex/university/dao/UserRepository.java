package ua.uz.alex.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.uz.alex.university.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
