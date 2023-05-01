package com.example.fitnessapi.repository;

import com.example.fitnessapi.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    /**
     * findBy is a JPA method, and we're making a custom query off it.
     * findByUserIdAndName returns an exercise based on user id and exercise name
     * @param userId used to filter exercises by user
     * @param exerciseName is what we're looking for
     * @return the exercise
     */
    Exercise findByUserIdAndName(Long userId, String exerciseName);

    /**
     * findByWorkoutId returns a list of exercises for a certain workout
     * @param workoutId is what we're filtering the exercises by
     * @return the list of exercises for the workout id
     */
    @Query("select e from Exercise e join e.workoutList w where w.id = :workoutId")
    List<Exercise> findByWorkoutId(@Param("workoutId") Long workoutId);

    /**
     * findByNameAndUserIdAndIdIsNot returns an exercise with a specific name
     * that belongs to the user, but does not have a certain exercise id.
     * This is to account for exercises that have the same name, but different ids.
     * @param exerciseName is what we're looking for
     * @param userId used to filter exercises by user
     * @param exerciseId the exercise id we don't want
     * @return the exercise
     */
    Exercise findByNameAndUserIdAndIdIsNot(String exerciseName, Long userId, Long exerciseId);
}
