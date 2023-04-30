package com.example.fitnessapi.model.repository;

import com.example.fitnessapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // user register

    /**
     * existsByEmailAddress is a custom method that
     * checks if a user already exists by their email address.
     * @param emailAddress is what we're looking up the user by
     * @return true if user exists, false if user does not exist
     */
    boolean existsByEmailAddress(String emailAddress);

    /**
     * findUserByEmailAddress is a custom method that
     * finds and returns us the user from an email address.
     * @param emailAddress is what we're looking up the user by
     * @return the User from the emailAddress
     */
    // user login
    User findUserByEmailAddress(String emailAddress);
}
