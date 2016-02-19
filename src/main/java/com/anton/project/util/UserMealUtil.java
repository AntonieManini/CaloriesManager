package com.anton.project.util;

import com.anton.project.model.UserMeal;
import com.anton.project.to.UserMealWithExceed;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

/**
 * Created by Anton on 19.02.16.
 */
public class UserMealUtil {
    public static List<UserMealWithExceed> getWithExceeded(Collection<UserMeal> all, int caloriesPerDay) {
        return null;
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(Collection<UserMeal> betweenDates, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        return null;
    }
}
