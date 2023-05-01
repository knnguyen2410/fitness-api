package com.example.fitnessapi.service;

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

// As a user, I can log into a website using my username and password
// http://localhost:9092/auth/users/login/

}
