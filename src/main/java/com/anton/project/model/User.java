package com.anton.project.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Anton on 17.02.16.
 */
public class User extends NamedEntity {

    private String email;
    private String password;
    private boolean enabled=true;
    private Date registered = new Date();
    private Set<Role> roles;
    private int caloriesPerDay;
    private List<UserMeal> meals;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public List<UserMeal> getMeals() {
        return meals;
    }

    public void setMeals(List<UserMeal> meals) {
        this.meals = meals;
    }
}
