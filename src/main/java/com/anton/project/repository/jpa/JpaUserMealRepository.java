package com.anton.project.repository.jpa;

import com.anton.project.model.UserMeal;
import com.anton.project.repository.UserMealRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Anton on 18.02.16.
 */

@Repository
public class JpaUserMealRepository implements UserMealRepository {
    @Override
    public UserMeal save(UserMeal userMeal, int UserId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return null;
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
