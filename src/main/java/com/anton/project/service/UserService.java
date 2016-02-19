package com.anton.project.service;

import com.anton.project.model.User;
import com.anton.project.to.UserTo;

import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */
public interface UserService {
    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    void update(User user);

    void update(UserTo userTo);

    void enable(int id, boolean enable);
}
