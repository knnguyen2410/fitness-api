package com.example.fitnessapi.service;

import com.example.fitnessapi.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    public WorkoutRepository workoutRepository;

    @Autowired
    public void setWorkoutRepository(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    // (POST) As a user, I can create a new workout
    // http://localhost:9092/api/workouts/

    // (GET) As a user, I can see a list of all my workouts
    // http://localhost:9092/api/workouts/

    // (GET) As a user, I can see a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/

    // (PUT) As a user, I can update a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/

    // (DELETE) As a user, I can delete a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/

}
