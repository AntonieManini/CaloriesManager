package com.anton.project.to;

import com.anton.project.util.UserUtil;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Anton on 17.02.16.
 */
public class UserTo implements Serializable {
    static final long serialVersionUID = 1L;

    private int id;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @Size(min = 6, max = 64, message = " must be between 6 and 64 characters")
    private String password;

    @Range(min = 500, max = 5000)
    @NotNull(message = " must not be empty")
    private Integer caloriesPerDay = UserUtil.DEFAULT_CALORIES_PER_DAY;

    public UserTo() {}

    public UserTo(int id, String name, String email, String password, int caloriesPerDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.caloriesPerDay = caloriesPerDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = ((id == null) ? 0 : id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Integer getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(Integer caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }
}
