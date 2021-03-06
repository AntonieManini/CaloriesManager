package com.anton.project.to;

import java.time.LocalDateTime;

/**
 * Created by Anton on 17.02.16.
 */
public class UserMealWithExceed {
    private Integer id;
    private LocalDateTime dateTime;
    private String description;
    private int calories;
    private boolean exceed;

    public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExceed() {
        return exceed;
    }
}
