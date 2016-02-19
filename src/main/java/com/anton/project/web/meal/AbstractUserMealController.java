package com.anton.project.web.meal;

import com.anton.project.LoggedUser;
import com.anton.project.model.UserMeal;
import com.anton.project.service.UserMealService;
import com.anton.project.to.UserMealWithExceed;
import com.anton.project.util.UserMealUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Anton on 19.02.16.
 */
abstract class AbstractUserMealController {
    @Autowired
    UserMealService service;

    public UserMeal get(int id) {
        int userId = LoggedUser.id();

        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();

        service.delete(id, userId);
    }

    public List<UserMealWithExceed> getAll() {
        int userId = LoggedUser.id();

        return UserMealUtil.getWithExceeded(service.getAll(userId), LoggedUser.getCaloriesPerDay());
    }

    public void update(UserMeal meal, int id) {
        meal.setId(id);
        int userId = LoggedUser.id();

        service.update(meal, userId);
    }

    public UserMeal create(UserMeal meal) {
        meal.setId(null);
        int userId = LoggedUser.id();

        return service.save(meal, userId);
    }

    public List<UserMealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = LoggedUser.id();

        return UserMealUtil.getFilteredWithExceeded(
                service.getBetweenDates(startDate, endDate, userId), startTime, endTime, LoggedUser.getCaloriesPerDay()
        );
    }
}
