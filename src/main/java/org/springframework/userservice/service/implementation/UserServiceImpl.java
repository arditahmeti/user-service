package org.springframework.userservice.service.implementation;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;
import org.springframework.userservice.model.User;
import org.springframework.userservice.repository.UserRepository;
import org.springframework.userservice.service.UserService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * User service
 *
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(String firstName) {
        if (firstName != null)
            return userRepository.findAllByFirstName(firstName);
        else
            return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(this.hashUserPassword(user));
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(this.hashUserPassword(user));
    }

    @Override
    public Integer deleteUser(Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User hashUserPassword(User user) {
        String sha256hex = Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();
        user.setPassword(sha256hex);
        return user;
    }
}
