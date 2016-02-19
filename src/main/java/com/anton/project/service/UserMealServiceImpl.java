package com.anton.project.service;

import com.anton.project.model.UserMeal;
import com.anton.project.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Anton on 18.02.16.
 */

@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) {
        return repository.get(id, userId);
    }

    @Override
    public void delete(int id, int userId) {
        repository.delete(id, userId);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return null;
    }

    @Override
    public Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return null;
    }

}
