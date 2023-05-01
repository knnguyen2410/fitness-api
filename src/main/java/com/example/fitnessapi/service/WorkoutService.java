package com.example.fitnessapi.service;

import com.example.fitnessapi.exception.InformationExistException;
import com.example.fitnessapi.exception.InformationNotFoundException;
import com.example.fitnessapi.model.User;
import com.example.fitnessapi.model.Workout;
import com.example.fitnessapi.repository.WorkoutRepository;
import com.example.fitnessapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Workout createWorkout(Workout workoutObject){
        Workout workout = workoutRepository.findByUserIdAndName(WorkoutService.getCurrentLoggedInUser().getId(), workoutObject.getName());
        if (workout != null) {
            throw new InformationExistException("Workout with the name " + workoutObject.getName() + " already exists.");
        } else {
            workoutObject.setUser(getCurrentLoggedInUser());
            return workoutRepository.save(workoutObject);
        }
    }

    // (GET) As a user, I can see a list of all my workouts
    // http://localhost:9092/api/workouts/
    public List<Workout> getWorkouts(){
        List<Workout> workouts = workoutRepository.findByUserId(WorkoutService.getCurrentLoggedInUser().getId());
        if (workouts.isEmpty()) {
            throw new InformationNotFoundException("No workouts found for user id " + WorkoutService.getCurrentLoggedInUser().getId() + ".");
        } else {
            return workouts;
        }
    }

    // (GET) As a user, I can see a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    public Optional<Workout> getWorkout(Long workoutId){
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException("Workout with id " + workoutId + " not found.");
        } else {
            return Optional.of(workout);
        }
    }

    // (PUT) As a user, I can update a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    public Workout updateWorkout(Long workoutId, Workout workoutObject) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException("Workout with id " + workoutId + " not found.");
        } else {
            workout.setName(workoutObject.getName());
            workout.setDescription(workoutObject.getDescription());
            workout.setLength(workoutObject.getLength());
            workout.setUser(WorkoutService.getCurrentLoggedInUser());
            return workoutRepository.save(workout);
        }
    }

    // (DELETE) As a user, I can delete a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/

}
