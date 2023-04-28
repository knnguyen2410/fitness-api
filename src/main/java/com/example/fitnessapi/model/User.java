package com.example.fitnessapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity // indicates that this class is referencing a table
@Table(name = "users") // table name we'll see is pgAdmin4
public class User {

    // class variables
    @Id // this is our PK (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gives PK the next unused integer
    @Column
    private Long id;

    @Column
    private String emailAddress;

    @Column
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    // outline class relationships as seen in ERD

    // one user can have many workouts
    @OneToMany(mappedBy = "user", orphanRemoval = true) // orphanRemoval removes the workout from database if we deleted it from a user
    @LazyCollection(LazyCollectionOption.FALSE) // all workouts will be eagerly loaded (all data is retrieved together from the database)
    private List<Workout> workoutList;

    // one user can have many exercises
    @OneToMany(mappedBy = "user", orphanRemoval = true) // orphanRemoval removes the workout from database if we deleted it from a user
    @LazyCollection(LazyCollectionOption.FALSE) // all workouts will be eagerly loaded (all data is retrieved together from the database)
    private List<Exercise> exerciseList;

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

    // getters and setters for class relationships
    public List<Workout> getWorkoutList() {
        return workoutList;
    }

    public void setWorkoutList(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
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
