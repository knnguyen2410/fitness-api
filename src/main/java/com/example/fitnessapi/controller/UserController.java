package com.example.fitnessapi.controller;

import com.example.fitnessapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // http://localhost:9092/auth/users/register/
// As a user, I can register for an account using my email address, and set a username and password.
// http://localhost:9092/auth/users/login/
// As a user, I can log into a website using my username and password

}
