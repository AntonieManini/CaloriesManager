package com.anton.project.service;

import com.anton.project.model.User;

/**
 * Created by Anton on 18.02.16.
 */
public interface UserService {
    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    void update(User user);

    void enable(int id, boolean enable);
}
