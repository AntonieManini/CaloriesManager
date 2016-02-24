package com.anton.project.util;

import com.anton.project.model.UserMeal;
import com.anton.project.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Anton on 19.02.16.
 */
public class UserMealUtil {

    public static UserMealWithExceed createWithExceed(UserMeal m, boolean exceeded) {
        return new UserMealWithExceed(m.getId(), m.getDateTime(), m.getDescription(), m.getCalories(), exceeded);
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(Collection<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream().collect(
                Collectors.groupingBy((m -> m.getDateTime().toLocalDate()), Collectors.summingInt(UserMeal::getCalories))
        );

        return mealList.stream()
                .filter(m -> TimeUtil.isBetween(m.getDateTime().toLocalTime(), startTime, endTime))
                .map(m -> createWithExceed(m, caloriesSumByDate.get(m.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static List<UserMealWithExceed> getWithExceeded(Collection<UserMeal> mealList, int caloriesPerDay) {
        return getFilteredWithExceeded(mealList, LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
    }
}
