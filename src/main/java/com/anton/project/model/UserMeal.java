package com.anton.project.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Anton on 17.02.16.
 */


@NamedQueries({
        @NamedQuery(name = UserMeal.GET, query = ""),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = ""),
        @NamedQuery(name = UserMeal.DELETE, query = ""),
        @NamedQuery(name = UserMeal.GET_BETWEEN, query = "")
})

@Entity
public class UserMeal extends BaseEntitiy {
    public static final String GET = "UserMeal.get";
    public static final String ALL_SORTED = "UserMeal.getAll";
    public static final String DELETE = "UserMeal.delete";
    public static final String GET_BETWEEN = "UserMeal.getBetween";

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name="date_time", nullable = false)
    private LocalDateTime dateTime;

    @NotEmpty
    @Column(name="description", nullable = false)
    private String description;

    @NotNull
    @Range(min=10, max=5000)
    @Column(name="calories", nullable = false)
    private Integer calories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
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
