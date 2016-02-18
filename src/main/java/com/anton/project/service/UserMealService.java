package com.anton.project.service;

import com.anton.project.model.UserMeal;

import java.util.Collection;

/**
 * Created by Anton on 18.02.16.
 */
public interface UserMealService {
    UserMeal get(int id, int userId);

    void delete(int id, int userId);

    Collection<UserMeal> getAll(int userId);

    UserMeal update(UserMeal meal, int userId);

    UserMeal save(UserMeal meal, int userId);
}
