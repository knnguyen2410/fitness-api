package com.example.fitnessapi.controller;

import com.example.fitnessapi.model.User;
import com.example.fitnessapi.model.request.LoginRequest;
import com.example.fitnessapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this is a rest controller for our rest api
@RequestMapping(path = "/auth/users/") // this is the designated url path: http://localhost:9092/auth/users/
public class UserController {

    public UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // As a user, I can register for an account using my email address, and set a username and password.
    // http://localhost:9092/auth/users/register/
    @PostMapping(path = "/register/")
    public User createUser(@RequestBody User userObject){
        return userService.createUser(userObject);
    }

    // As a user, I can log into a website using my username and password
    // http://localhost:9092/auth/users/login/
    @PostMapping(path = "/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }
}
