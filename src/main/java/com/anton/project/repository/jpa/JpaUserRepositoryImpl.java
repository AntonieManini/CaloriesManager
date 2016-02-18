package com.anton.project.repository.jpa;

import com.anton.project.model.User;
import com.anton.project.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */

@Repository
public class JpaUserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
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
    public List<User> getAll() {
        return null;
    }
}
