package com.anton.project.repository;

import com.anton.project.model.User;

import java.util.List;

/**
 * Created by Anton on 17.02.16.
 */
public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    User getWithMeals(int id);
}
