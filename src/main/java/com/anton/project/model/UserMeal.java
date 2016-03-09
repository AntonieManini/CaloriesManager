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
        @NamedQuery(name = UserMeal.GET, query = "SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC"),
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.GET_BETWEEN,
                query = "SELECT m from UserMeal m WHERE m.user.id=:userId " +
                        " AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC")
})
@Entity
@Table(name = "meals")
public class UserMeal extends BaseEntitiy {
    public static final String GET = "UserMeal.get";
    public static final String ALL_SORTED = "UserMeal.getAll";
    public static final String DELETE = "UserMeal.delete";
    public static final String GET_BETWEEN = "UserMeal.getBetween";

    @NotNull
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserMeal(){}

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

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

    @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
