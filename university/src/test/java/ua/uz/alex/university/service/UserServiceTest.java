package ua.uz.alex.university.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.uz.alex.university.dao.UserRepository;
import ua.uz.alex.university.domain.User;
import ua.uz.alex.university.domain.UserRole;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    @DisplayName("Test findByEmail Success")
    void testFindByEmail() {

        User user = new User("new@new", "new", "user", UserRole.ROLE_USER, "1");
        doReturn(Optional.of(user)).when(repository).findByEmail("new@new");
        Optional<User> returnedUser = service.findByEmail("new@new");
        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The user returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findByEmail Not Found")
    void testFindByEmailNotFound() {
        User user = new User("new@new", "new1", "user1", UserRole.ROLE_USER, "1");
        doReturn(Optional.empty()).when(repository).findByEmail("new@new");
        Optional<User> returnedUser = service.findByEmail("new@new");
        // Assert the response
        Assertions.assertFalse(returnedUser.isPresent(), "User should not be found");
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        User user = new User(0, "new@new2", "new", "user", UserRole.ROLE_USER, "1");
        doReturn(Optional.of(user)).when(repository).findById(0);
        Optional<User> returnedUser = service.findById(0);
        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The user returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {

        doReturn(Optional.empty()).when(repository).findById(1);
        Optional<User> returnedUser = service.findById(1);
        // Assert the response
        Assertions.assertFalse(returnedUser.isPresent(), "User should not be found");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
         User user3 = new User("new@new3", "new3", "user3", UserRole.ROLE_USER, "1");
         User user4 = new User("new@new4", "new4", "user4", UserRole.ROLE_USER, "1");
        doReturn(Arrays.asList(user3, user4)).when(repository).findAll();
        List<User> users = service.findAll();
        // Assert the response
        Assertions.assertEquals(2, users.size(), "findAll should return 2 users");
    }

    @Test
    @DisplayName("Test save user")
    void testSave() {
        User user = new User(1, "new@new5", "new3", "user3", UserRole.ROLE_USER, "1");
        doReturn(user).when(repository).save(any());
        User returnedUser = service.save(user);
        // Assert the response
        Assertions.assertNotNull(returnedUser, "The saved user should not be null");
    }
}
