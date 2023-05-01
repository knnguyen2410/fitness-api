package com.example.fitnessapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private WorkoutService workoutService;

    @Autowired
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

// http://localhost:9092/api/workouts/
// (POST) As a user, I can create a new workout
// http://localhost:9092/api/workouts/
// (GET) As a user, I can see a list of all my workouts
// http://localhost:9092/api/workouts/{workoutId}/
// (GET) As a user, I can see a certain workout
// http://localhost:9092/api/workouts/{workoutId}/
// (PUT) As a user, I can update a certain category
// http://localhost:9092/api/workouts/{workoutId}/
// (DELETE) As a user, I can delete a certain workout

}
