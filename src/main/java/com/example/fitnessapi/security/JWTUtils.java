package com.example.fitnessapi.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class JWTUtils {

    // logger allows us to save information in server's memory, but not hard drive
    Logger logger = Logger.getLogger(JWTUtils.class.getName());

    // insert secret key at runtime
    @Value("${jwt-secret}")
    private String jwtSecret; // comes from dev properties

    // insert expiration date at runtime
    @Value("${jwt-expiration-ms}")
    private int jwtExpirationMs; // comes from dev properties

    /**
     * generateJwtToken uses the user's details (email address) to create a jwt token.
     * This method runs once after the user is authenticated.
     * @param myUserDetails email address is used
     * @return a json web token for the user
     */
    public String generateJwtToken(MyUserDetails myUserDetails) {
        return Jwts.builder()
                .setSubject((myUserDetails.getUsername())) // gets email address only (keep info to a minimum)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // ms comes from @value
                .signWith(SignatureAlgorithm.HS256, jwtSecret) // comes from @value
                .compact();
    }

    /**
     * getUserNameFromJwtToken takes the jwt string and
     * This method runs multiple times (for each subsequent user request).
     * Once the server receives the token, the server looks at the token payload (subject),
     * and returns user information.
     * @param token - this is the jwt we generated
     * @return the subject of the jwt
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }


}