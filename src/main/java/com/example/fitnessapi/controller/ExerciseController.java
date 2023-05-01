package com.example.fitnessapi.controller;

import com.example.fitnessapi.model.Exercise;
import com.example.fitnessapi.service.ExerciseService;
import com.example.fitnessapi.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController // this is a rest controller for our rest api
@RequestMapping(path = "/api/") // this is the designated url path: http://localhost:9092/api/
public class ExerciseController {

    public ExerciseService exerciseService;
    public WorkoutService workoutService;

    @Autowired
    public void setExerciseService(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Autowired
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    /**
     * createWorkoutExercise uses the createWorkoutExercise from the exerciseService
     * to create a new exercise for a certain workout.
     * @param workoutId is the workout we want to make a new exercise in
     * @param exerciseObject is the exercise we want to make
     * @return calls upon the createWorkoutExercise in the exerciseService
     */
    // (POST) As a user, I can create a new exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/
    @PostMapping(path = "/workouts/{workoutId}/exercises/")
    public Exercise createWorkoutExercise(@PathVariable Long workoutId, @RequestBody Exercise exerciseObject){
        return exerciseService.createWorkoutExercise(workoutId, exerciseObject);
    }

    /**
     * getWorkoutExercises uses the getWorkoutExercises method from the exerciseService
     * to get a list of all exercises for a certain workout.
     * @param workoutId is the workout we want to get all the exercises of
     * @return calls upon the getWorkoutExercises in the exerciseService
     */
    // (GET) As a user, I can get a list of all my exercises for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/
    @GetMapping(path = "/workouts/{workoutId}/exercises/")
    public List<Exercise> getWorkoutExercises(@PathVariable Long workoutId){
        return exerciseService.getWorkoutExercises(workoutId);
    }

    /**
     * updateWorkoutExercise uses the updateWorkoutExercise method from the exerciseService
     * to update a certain exercise for a certain workout.
     * @param workoutId the workout we want to update
     * @param exerciseId the exercise we want to update
     * @param exerciseObject what we want the exercise to update to
     * @return calls upon the updateWorkoutExercise in the exerciseService
     */
    // (PUT) As a user, I can update a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}/
    @PutMapping(path = "/workouts/{workoutId}/exercises/{exerciseId}/")
    public Exercise updateWorkoutExercise (@PathVariable Long workoutId, @PathVariable Long exerciseId, @RequestBody Exercise exerciseObject){
        return exerciseService.updateWorkoutExercise(workoutId, exerciseId, exerciseObject);
    }

    /**
     * deleteWorkoutExercise uses the deleteWorkoutExercise method from the exerciseService
     * @param workoutId is the workout where the exercise is located
     * @param exerciseId is the exercise we want to delete
     * @return calls upon the deleteWorkoutExercise in the exerciseService
     */
    // (DELETE) As a user, I can delete a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}/
    @DeleteMapping(path = "/workouts/{workoutId}/exercises/{exerciseId}/")
    public ResponseEntity<HashMap<String, String>> deleteWorkoutExercise(
            @PathVariable Long workoutId, @PathVariable Long exerciseId) {
        exerciseService.deleteWorkoutExercise(workoutId, exerciseId);
        HashMap<String, String> responseMessage = new HashMap<>();
        responseMessage.put("Status", "Exercise with id: " + exerciseId + " was successfully deleted.");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
