package com.anton.project.repository;

import com.anton.project.model.UserMeal;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Anton on 17.02.16.
 */
public interface UserMealRepository {
    UserMeal save(UserMeal userMeal, int UserId);

    boolean delete(int id, int userId);

    UserMeal get(int id, int userId);

    Collection<UserMeal> getAll(int userId);

    Collection<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
