package com.example.fitnessapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity // indicates that this class is referencing a table
@Table(name = "workouts") // database table name
public class Workout {

    // class variables
    @Id // this is our PK (primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gives PK the next unused integer
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer length;

    // outline class relationships as seen in ERD
    // many workouts can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore // don't want user information to be included in workout info
    private User user;

    // One workout can have many exercises
    @OneToMany(mappedBy = "workout", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Exercise> exerciseList;

    // default (no-arg) constructor
    public Workout(){}

    // constructor
    public Workout(Long id, String name, String description, Integer length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    // getters and setters for class relationships

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", length=" + length +
                '}';
    }
}
