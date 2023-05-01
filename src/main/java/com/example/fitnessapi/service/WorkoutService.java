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

    /**
     * createWorkout takes in a workoutObject and returns a new workout.
     * If the workout name already exists, throw an exception
     * @param workoutObject is what we want to create
     * @return the workout object
     */
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

    /**
     * getWorkouts goes to the endpoint and returns a list of all workouts for the logged-in user.
     * If the user doesn't have any workouts, throw an exception.
     * @return a list of workouts.
     */
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

    /**
     * updateWorkouts uses a list of workout objects to update the current workout list.
     * If the user doesn't have any workouts, throw an exception.
     * @param workoutObjects is what we want to update the workouts to
     * @return a list of updated workouts for the logged-in user
     */
    // (PUT) As a user, I can update all my workouts
    // http://localhost:9092/api/workouts/
    public List<Workout> updateWorkouts(List<Workout> workoutObjects) {
        List<Workout> workouts = workoutRepository.findByUserId(WorkoutService.getCurrentLoggedInUser().getId());
        if (workouts.isEmpty()) {
            throw new InformationNotFoundException("No workouts found for user id " + WorkoutService.getCurrentLoggedInUser().getId() + ".");
        } else {
            for (int i = 0; i < workouts.size(); i++){
                Workout workout = workouts.get(i);
                Workout workoutObject = workoutObjects.get(i);
                workout.setName(workoutObject.getName());
                workout.setDescription(workoutObject.getDescription());
                workout.setLength(workoutObject.getLength());
            }
           return workoutRepository.saveAll(workouts);
        }
    }

    /**
     * deleteWorkouts deletes all workouts for the currently logged-in user.
     * If the user doesn't have any workouts, throw an exception.
     * @return
     */
    // (DELETE) As a user, I can delete all my workouts
    // http://localhost:9092/api/workouts/
    public String deleteWorkouts() {
        List<Workout> workouts = workoutRepository.findByUserId(WorkoutService.getCurrentLoggedInUser().getId());
        if (workouts.isEmpty()) {
            throw new InformationNotFoundException("No workouts found for user id " + WorkoutService.getCurrentLoggedInUser().getId() + ".");
        } else {
            workoutRepository.deleteAll(workouts);
            return "All workouts for user id " + WorkoutService.getCurrentLoggedInUser().getId() + " have been successfully deleted.";
        }
    }

    /**
     * getWorkout returns a single workout for the user based on the user id.
     * If the workout id doesn't exist, throw an error.
     * @param workoutId is the workout we're looking for
     * @return a message to the user that all workouts have been successfully deleted
     */
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

    /**
     * updateWorkout updates a certain workout with the workoutObject's details.
     * If the workout id doesn't exist, throw an error
     * @param workoutId is the workout we want to update
     * @param workoutObject contains the details that we want to update to
     * @return the updated workout
     */
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
            return workoutRepository.save(workout);
        }
    }

    /**
     * deleteWorkout deletes a certain workout that the user has.
     * If the workout id doesn't exist, throw an error.
     * @param workoutId is the workout we want to delete
     * @return a message to the user that the workout has been successfully deleted
     */
    // (DELETE) As a user, I can delete a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    public String deleteWorkout(Long workoutId) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException("Workout with id " + workoutId + " not found.");
        } else {
            workoutRepository.deleteById(workoutId);
            return "Workout with id " + workoutId + " has been successfully deleted.";
        }
    }
}
