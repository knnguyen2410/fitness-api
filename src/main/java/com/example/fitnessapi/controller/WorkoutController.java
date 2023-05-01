package com.example.fitnessapi.controller;

import com.example.fitnessapi.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this is a rest controller for our rest api
@RequestMapping(path = "/api/") // this is the designated url path: http://localhost:9092/api/
public class WorkoutController {

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
