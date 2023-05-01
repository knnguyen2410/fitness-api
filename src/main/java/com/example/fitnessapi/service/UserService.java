package com.example.fitnessapi.service;

import com.example.fitnessapi.model.User;
import com.example.fitnessapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // As a user, I can register for an account using my email address, and set a username and password.
    // http://localhost:9092/auth/users/register/

    // As a user, I can log into a website using my email and password
    // http://localhost:9092/auth/users/login/

    /**
     * findUserByEmailAddress returns a user from their email address
     * @param emailAddress is used to find the user
     * @return the user
     */
    public User findUserByEmailAddress(String emailAddress) {
        return userRepository.findUserByEmailAddress(emailAddress);
    }
}
