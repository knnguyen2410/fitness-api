package com.example.fitnessapi.model.request;

public class LoginRequest {
    // a user uses a userName and password to login
    private String userName;
    private String password;

    // create getters only since we are not setting these
    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}