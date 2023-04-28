package com.example.fitnessapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // indicates that this class is referencing a table
@Table(name = "users") // table name we'll see is pgAdmin4
public class User {

    // class variables
    private Long id;
    private String emailAddress;
    private String userName;
    private String password;

    // default (no-arg) constructor
    public User(){}

    // constructor
    public User(Long id, String emailAddress, String userName, String password){
        this.id = id;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.password = password;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
