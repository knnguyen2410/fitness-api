package com.example.fitnessapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    // logger allows us to save information in server's memory, but not hard drive
    Logger logger = Logger.getLogger(JWTRequestFilter.class.getName());

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    /**
     * parseJwt autheticates the json web token.
     * This method is called upon after the user has already been validated.
     * @param request is the jwt to the server
     * @return the jwt key after "bearer "
     */
    private String parseJwt(HttpServletRequest request) {  // the request is what we're sending to the server
        String headerAuth = request.getHeader("Authorization"); // .getheader is the key-value pair. for example, "Authorization" : "Bearer"
        if (StringUtils.hasLength("headerAuth") && headerAuth.startsWith("Bearer")) {
            return headerAuth.substring(7);
        }
        return null;
    }

    /**
     * doFilterInternal is a method implemented by OncePerRequestFilter.
     * This method checks if the jwt key is valid or not null,
     * then grabs the email address from jwt payload to authenticate the user.
     * @param request is the HttpServletRequest object
     * @param response is the HttpServletResponse object
     * @param filterChain are all the filters we're running on the jwt
     * @throws ServletException if there's a servlet error
     * @throws IOException if there's an i/o error (input/output)
     */
    // sending our CRUD end request, we're immediately here
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            // check if the jwt key is valid and not null
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) { // .validateJwtToken is the method we made earlier int he JWTUtils class
                // grab email address from jwt payload
                // if valid get user email from the key
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                // find the user details by user email address
                // load user details from the key
                UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);
                // authenticate the user, these are the user login details
                // set username and password authentication token from user user details
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // build the user token
                // build request and get security content
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // set security context
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.info("Cannot set user authentication");
        }
        filterChain.doFilter(request, response);
    }
}
