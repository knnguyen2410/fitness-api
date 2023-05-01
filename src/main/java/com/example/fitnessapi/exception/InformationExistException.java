package com.example.fitnessapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Allows us to handle errors that arise from a conflict where a certain argument already exists.
 * We can return a message to the user with more details on why this exception occurred.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class InformationExistException extends RuntimeException{
    public InformationExistException(String message){
        super(message);
    }
}