package com.example.fitnessapi.service;

import com.example.fitnessapi.exception.InformationExistException;
import com.example.fitnessapi.exception.InformationNotFoundException;
import com.example.fitnessapi.model.Exercise;
import com.example.fitnessapi.model.Workout;
import com.example.fitnessapi.repository.ExerciseRepository;
import com.example.fitnessapi.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;
    private WorkoutRepository workoutRepository;

    @Autowired
    public void setExerciseRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Autowired
    public void setWorkoutRepository(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    /**
     * createWorkoutExercise creates a new exercise for a certain workout id.
     * If the workout doesn't exist, or the exercise already exists, throw an exception.
     * @param workoutId is the workout we want to make a new exercise in
     * @param exerciseObject is the exercise we want to make
     * @return the new exercise object
     */
    // (POST) As a user, I can create a new exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/
    public Exercise createWorkoutExercise(Long workoutId, Exercise exerciseObject) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException(
                    "Workout with id " + workoutId + " does not belong to this user or workout does not exist.");
        }
        Exercise exercise = exerciseRepository.findByUserIdAndName(WorkoutService.getCurrentLoggedInUser().getId(), exerciseObject.getName());
        if (exercise != null) {
            throw new InformationExistException("Exercise with name " + exercise.getName() + " already exists.");
        }
        exerciseObject.setUser(WorkoutService.getCurrentLoggedInUser());
        exerciseObject.setWorkoutList(Arrays.asList(workout));
        return exerciseRepository.save(exerciseObject);
    }

    /**
     * getWorkoutExercises returns a list of all exercises for a certain workout.
     * If the workout doesn't exist throw an exception.
     * @param workoutId is the workout we want to get all the exercises of
     * @return a list of exercises
     */
    // (GET) As a user, I can get a list of all my exercises for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/
    public List<Exercise> getWorkoutExercises(Long workoutId) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException(
                    "Workout with id " + workoutId + " does not belong to this user or workout does not exist.");
        }
        return workout.getExerciseList();
    }

    // (GET) As a user, I can get a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}

    // (PUT) As a user, I can update a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}

    // (DELETE) As a user, I can delete a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
}
