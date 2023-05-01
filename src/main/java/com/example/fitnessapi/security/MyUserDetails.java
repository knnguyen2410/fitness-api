package com.example.fitnessapi.security;

import com.example.fitnessapi.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserDetails implements UserDetails {

    // create instance of user
    // private means not accessible by other classes
    // final means user value cannot be changed
    private final User user;

    // constructor
    public MyUserDetails(User user){
        this.user = user;
    }

    // getter only, since we're not setting the user
    public User getUser(){
        return user;
    }

    // methods implemented from UserDetails interface
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
