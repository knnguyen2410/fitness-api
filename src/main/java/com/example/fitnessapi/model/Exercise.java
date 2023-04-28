package com.example.fitnessapi.model;

import javax.persistence.*;

@Entity // indicates that this class is referencing a table
@Table(name = "exercises") // database table name
public class Exercise {

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
    private Integer sets;

    @Column
    private Integer reps;

    @Column
    private Integer duration;

    // default (no-arg) constructor
    public Exercise(){}

    // constructor
    public Exercise(Long id, String name, String description, Integer sets, Integer reps, Integer duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
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

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    // toString method
    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", duration=" + duration +
                '}';
    }
}