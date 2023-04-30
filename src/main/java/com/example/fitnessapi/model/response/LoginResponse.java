package com.example.fitnessapi.model.response;

public class LoginResponse {
    // this is the response message that the user sees after a login attempt
    private String message;

    // constructor
    public LoginResponse(String message){
        this.message = message;
    }

    // getters and setters
    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
