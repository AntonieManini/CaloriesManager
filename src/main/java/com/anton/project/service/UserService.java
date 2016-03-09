package com.anton.project.service;

import com.anton.project.model.User;
import com.anton.project.to.UserTo;
import com.anton.project.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */
public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user);

    void update(UserTo userTo);

    void enable(int id, boolean enable);
}
