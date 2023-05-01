package com.example.fitnessapi.service;

import com.example.fitnessapi.model.User;
import com.example.fitnessapi.repository.WorkoutRepository;
import com.example.fitnessapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    public WorkoutRepository workoutRepository;

    @Autowired
    public void setWorkoutRepository(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    /**
     * getCurrentLoggedInUser returns the currently logged-in user
     * @return the user that's logged in
     */
    public static User getCurrentLoggedInUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
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
