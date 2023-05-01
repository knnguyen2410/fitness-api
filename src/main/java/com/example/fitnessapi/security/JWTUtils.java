package com.example.fitnessapi.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JWTUtils {

    // logger allows us to save information in server's memory, but not hard drive
    Logger logger = Logger.getLogger(JWTUtils.class.getName());
}