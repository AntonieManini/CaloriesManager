package com.anton.project.service;

import com.anton.project.model.User;
import com.anton.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Anton on 18.02.16.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        repository.save(user);
    }
}
