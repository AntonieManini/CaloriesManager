package com.anton.project.model;

import com.anton.project.util.UserUtil;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Anton on 17.02.16.
 */

@Entity
@Table(name="users")
public class User extends NamedEntity {

    @Email
    @NotEmpty
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Length(min=6)
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="enabled", nullable = false)
    private boolean enabled=true;

    @Column(name="registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role")
    private Set<Role> roles;

    @Digits(fraction = 0, integer = 4)
    @Column(name="calories_per_day", columnDefinition = "default 2000")
    private int caloriesPerDay = UserUtil.DEFAULT_CALORIES_PER_DAY;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy="user")
    @OrderBy("dateTime DESC")
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
