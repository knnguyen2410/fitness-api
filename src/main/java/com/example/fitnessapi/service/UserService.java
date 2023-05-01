package com.example.fitnessapi.service;

import com.example.fitnessapi.exception.InformationExistException;
import com.example.fitnessapi.model.User;
import com.example.fitnessapi.repository.UserRepository;
import com.example.fitnessapi.security.JWTUtils;
import com.example.fitnessapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTUtils jwtUtils; // from security configuration class
    private AuthenticationManager authenticationManager; // from security configuration class
    private MyUserDetails myUserDetails; // from security configuration class

    @Autowired
    public UserService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder, // lazy waits for bean to be made before injecting
                       JWTUtils jwtUtils,
                       @Lazy AuthenticationManager authenticationManager,
                       @Lazy MyUserDetails myUserDetails) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myUserDetails = myUserDetails;
    }

    /**
     * createUser takes in a user object and creates a new user.
     * If the email address in the user object already belongs to a user,
     * throw an InformationExistException message.
     * @param userObject used to create a user with a unique email address
     * @return a new user
     */
    // As a user, I can register for an account using my email address, and set a username and password.
    // http://localhost:9092/auth/users/register/
    public User createUser(User userObject) {
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new InformationExistException("User with the email address" + userObject.getEmailAddress() + " already exists.");
        }
    }

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
