package com.example.fitnessapi.service;

import com.example.fitnessapi.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public void setExerciseRepository(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

// http://localhost:9092/api/workouts/{workoutId}/exercises/
// (POST) As a user, I can create a new exercise for a certain workout
// http://localhost:9092/api/workouts/{workoutId}/exercises/
// (GET) As a user, I can get a list of all my exercises for a certain workout
// http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
// (GET) As a user, I can get a certain exercise for a certain workout
// http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
// (PUT) As a user, I can update a certain exercise for a certain workout
// http://localhost:9092/api/workouts/{workoutId}/exercises/{exerciseId}
// (DELETE) As a user, I can delete a certain exercise for a certain workout

}
