package com.example.fitnessapi.controller;

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

    /**
     * createWorkout uses the createWorkout method from the workoutService
     * to create a workout for a user
     * @param workoutObject contains the details of the new workout we want to make
     * @return calls upon the createWorkout method from the workoutService
     */
    // (POST) As a user, I can create a new workout
    // http://localhost:9092/api/workouts/
    @PostMapping(path = "/workouts/")
    public Workout createWorkout(@RequestBody Workout workoutObject){
        return workoutService.createWorkout(workoutObject);
    }

    /**
     * getWorkouts uses the getWorkouts method from workoutService
     * to get a list of a user's workouts
     * @return calls upon the getWorkouts method from the workoutService
     */
    // (GET) As a user, I can see a list of all my workouts
    // http://localhost:9092/api/workouts/
    @GetMapping(path = "/workouts/")
    public List<Workout> getWorkouts(){
        return workoutService.getWorkouts();
    }

    /**
     * updateWorkouts uses the updateWorkouts from workoutService
     * to get an updated list of all workouts
     * @param workoutObjects is what we want to update all the workouts to
     * @return calls upon the updateWorkouts from workoutService
     */
    // (PUT) As a user, I can update all my workouts
    // http://localhost:9092/api/workouts/
    @PutMapping(path = "/workouts/")
    public List<Workout> updateWorkouts (@RequestBody List<Workout> workoutObjects){
        return workoutService.updateWorkouts(workoutObjects);
    }

    // (DELETE) As a user, I can delete all my workouts
    // http://localhost:9092/api/workouts/
    @DeleteMapping(path = "/workouts/")
    public String deleteWorkouts (){
        return workoutService.deleteWorkouts();
    }

    /**
     * getWorkout uses the getWorkout method from workoutService
     * to update a get a user's specific workout
     * @param workoutId is the workout we want to get
     * @return calls upon the getWorkout method from the workoutService
     */
    // (GET) As a user, I can see a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    @GetMapping(path = "/workouts/{workoutId}/")
    public Optional<Workout> getWorkout(@PathVariable Long workoutId){
        return workoutService.getWorkout(workoutId);
    }

    /**
     * updateWorkout uses the updateWorkout method from workoutService
     * to update a user's specific workout
     * @param workoutId is the workout we want to update
     * @param workoutObject contains the details that we want to update to
     * @return calls upon the updateWorkout method from workoutService
     */
    // (PUT) As a user, I can update a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    @PutMapping(path = "/workouts/{workoutId}/")
    public Workout updateWorkout (@PathVariable Long workoutId, @RequestBody Workout workoutObject){
        return workoutService.updateWorkout(workoutId, workoutObject);
    }

    /**
     * deleteWorkout uses the deleteWorkout method from workoutService
     * to delete a user's workout
     * @param workoutId is the workout we want to delete
     * @return calls upon the deleteWorkout method from workoutService
     */
    // (DELETE) As a user, I can delete a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/
    @DeleteMapping(path = "/workouts/{workoutId}/")
    public String deleteWorkout (@PathVariable Long workoutId){
        return workoutService.deleteWorkout(workoutId);
    }
}
