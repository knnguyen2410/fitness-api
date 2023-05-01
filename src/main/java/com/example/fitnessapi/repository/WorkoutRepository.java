package com.example.fitnessapi.repository;

import com.example.fitnessapi.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    /**
     * findBy is a JPA method, and we're making a custom query off it.
     * findByUserIdAndName returns a workout based on user id and workout name
     * @param UserId used to filter workouts by user
     * @param workoutName is what we're looking for
     * @return the workout
     */
    Workout findByUserIdAndName(Long UserId, String workoutName);

    /**
     * findByUserId returns a list of workouts based on the user id
     * @param userId used to filter workouts by user
     * @return the list of workouts for a user
     */
    List<Workout> findByUserId(Long userId);

    /**
     * findByIdAndUserId returns a workout based on the workout id and user is
     * @param workoutId is what we're looking for
     * @param userId used to filter workouts by user
     * @return the workout
     */
    Workout findByIdAndUserId(Long workoutId, Long userId);
}
