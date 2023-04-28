package com.example.fitnessapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity // indicates that this class is referencing a table
@Table(name = "workouts") // database table name
public class Workout {

    // class variables
    private Long id;
    private String name;
    private String description;
    private Integer length;

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