package com.anton.project.model;

import java.time.LocalDateTime;

/**
 * Created by Anton on 17.02.16.
 */
public class UserMeal extends BaseEntitiy {
    private LocalDateTime dateTime;
    private String description;
    private Integer calories;
    private User user;

    public UserMeal(){}

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
