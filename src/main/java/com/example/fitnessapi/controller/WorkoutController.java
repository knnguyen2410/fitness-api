package com.example.fitnessapi.controller;

import com.example.fitnessapi.exception.InformationExistException;
import com.example.fitnessapi.model.Workout;
import com.example.fitnessapi.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // this is a rest controller for our rest api
@RequestMapping(path = "/api/") // this is the designated url path: http://localhost:9092/api/
public class WorkoutController {

    private WorkoutService workoutService;

    @Autowired
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // (POST) As a user, I can create a new workout
    // http://localhost:9092/api/workouts/
    @PostMapping(path = "/workouts/")
    public Workout createWorkout(@RequestBody Workout workoutObject){
        return workoutService.createWorkout(workoutObject);
    }

    // (GET) As a user, I can see a list of all my workouts
    // http://localhost:9092/api/workouts/
    @GetMapping(path = "/workouts/")
    public List<Workout> getWorkouts(){
        return workoutService.getWorkouts();
    }

    // (GET) As a user, I can see a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    @GetMapping(path = "/workouts/{workoutId}/")
    public Optional<Workout> getWorkout(@PathVariable Long workoutId){
        return workoutService.getWorkout(workoutId);
    }

    // (PUT) As a user, I can update a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/

    // (DELETE) As a user, I can delete a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
}
