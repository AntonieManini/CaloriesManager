package com.anton.project.service;

import com.anton.project.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Anton on 18.02.16.
 */

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void enable(int id, boolean enable) {

    }
}
