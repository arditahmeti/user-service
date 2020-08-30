package org.springframework.userservice.service;

import org.springframework.userservice.model.User;

import java.util.List;
import java.util.Optional;

/**
 * User service
 *
 */
public interface UserService {
    List<User> getAllUsers(String firstName);

    Optional<User> getUserById(Integer id);

    User insertUser(User user);

    User updateUser(User user);

    Integer deleteUser(Integer id);

    User hashUserPassword(User user);
}
