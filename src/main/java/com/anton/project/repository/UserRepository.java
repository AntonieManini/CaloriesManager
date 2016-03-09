package com.anton.project.repository;

import com.anton.project.model.User;

import java.util.List;

/**
 * Created by Anton on 17.02.16.
 */
public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();
}
