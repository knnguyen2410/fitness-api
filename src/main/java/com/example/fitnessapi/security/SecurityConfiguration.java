package com.example.fitnessapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // this security configuration applies to entire app configuration
public class SecurityConfiguration {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void setMyUserDetailsService(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    /**
     * authJwtRequestFilter creates a new instance of the JWTRequestFilter,
     * so we can validate the jwt token.
     * @return a new JWTRequestFilter instance
     */
    @Bean
    public JWTRequestFilter authJwtRequestFilter(){
        return new JWTRequestFilter();
    }

    /**
     * passwordEncoder creates a new instance of the BCryptPasswordEncoder,
     * so we can salt and hash the user's password.
     * @return a new BCryptPasswordEncoder instance
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * filterChain creates a SecurityFilterChain bean (object) that filters all HTTTP requests to the server.
     * This method allows us to keep certain endpoints private and others public.
     * @param http is the incoming HTTP request from a user
     * @return a new SecurityFilterChain object
     * @throws Exception if the filter chain has an error
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{ // accepts a http server request
        http.authorizeRequests().antMatchers(
                        "/auth/users/register/",
                        "/auth/users/login/"
                ).permitAll()// these are all public urls
                .anyRequest().authenticated() // other urls need authentication
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // when you log into a server, you need to maintain a session. add this session so that our java springboot knows we're logged in
                .and().csrf().disable(); // connects front/back end if they're on different servers
        http.addFilterBefore(authJwtRequestFilter(), UsernamePasswordAuthenticationFilter.class); // added for JWT login
        return http.build();
    }

    /**
     * authenticationManager takes in an AuthenticationConfiguration object,
     * and returns an AuthenticationManager instance.
     * An AuthenticationManager can do one of 3 things in its authenticate() method:
     * 1. Return an Authentication (normally with authenticated=true) if it can verify that the input represents a valid principal
     * 2. Throw an AuthenticationException if it believes that the input represents an invalid principal
     * 3. Return null if it cannot decide
     * @param authConfig tells us how to create the AuthenticationManager
     * @return an AuthenticationManager instance
     * @throws Exception if AuthenticationConfiguration object has an error
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
