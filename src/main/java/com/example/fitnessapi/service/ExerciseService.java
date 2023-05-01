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
import java.util.Optional;

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

    /**
     * updateWorkoutExercise returns an updated exercise for a certain workout.
     * If the workout or exercise doesn't exist throw an exception.
     * @param workoutId the workout we want to update
     * @param exerciseId the exercise we want to update
     * @param exerciseObject what we want the exercise to update to
     * @return the updated exercise
     */
    // (PUT) As a user, I can update a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
    public Exercise updateWorkoutExercise(Long workoutId, Long exerciseId, Exercise exerciseObject) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException(
                    "Workout with id " + workoutId + " does not belong to this user or workout does not exist.");
        }
        Optional<Exercise> exercise = exerciseRepository.findByWorkoutId(workoutId).stream().filter(p -> p.getId().equals(exerciseId)).findFirst();
        if (exercise.isEmpty()) {
            throw new InformationNotFoundException("Exercise with id " + exerciseId + " does not belongs to this user or exercise does not exist.");
        }
        Exercise oldExercise = exerciseRepository.findByNameAndUserIdAndIdIsNot(exerciseObject.getName(), WorkoutService.getCurrentLoggedInUser().getId(), exerciseId);
        if (oldExercise != null) {
            throw new InformationExistException("Exercise with name " + oldExercise.getName() + " already exists.");
        }
        exercise.get().setName(exerciseObject.getName());
        exercise.get().setDescription(exerciseObject.getDescription());
        exercise.get().setSets(exerciseObject.getSets());
        exercise.get().setReps(exerciseObject.getReps());
        exercise.get().setDuration(exerciseObject.getDuration());
        return exerciseRepository.save(exercise.get());
    }

    /**
     * deleteWorkoutExercise deletes a certain exercise for a specific workout.
     * If the workout or exercise doesn't exist throw an exception.
     * @param workoutId is the workout where the exercise is located
     * @param exerciseId is the exercise we want to delete
     */
    // (DELETE) As a user, I can delete a certain exercise for a certain workout
    // http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
    public void deleteWorkoutExercise(Long workoutId, Long exerciseId) {
        Workout workout = workoutRepository.findByIdAndUserId(workoutId, WorkoutService.getCurrentLoggedInUser().getId());
        if (workout == null) {
            throw new InformationNotFoundException(
                    "Workout with id " + workoutId + " does not belong to this user or workout does not exist.");
        }
        Optional<Exercise> exercise = exerciseRepository.findByWorkoutId(workoutId).stream().filter(p -> p.getId().equals(exerciseId)).findFirst();
        if (exercise.isEmpty()) {
            throw new InformationNotFoundException("Exercise with id " + exerciseId + " does not belongs to this user or recipe does not exist.");
        }
        exerciseRepository.deleteById(exercise.get().getId());
    }
}
