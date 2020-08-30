package org.springframework.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.userservice.model.User;

import java.util.List;

/**
 * User repository
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByFirstName(String firstName);
}
