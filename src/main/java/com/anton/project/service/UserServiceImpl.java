package com.anton.project.service;

import com.anton.project.LoggedUser;
import com.anton.project.model.User;
import com.anton.project.repository.UserRepository;
import com.anton.project.to.UserTo;
import com.anton.project.util.UserUtil;
import com.anton.project.util.exception.ExceptionUtil;
import com.anton.project.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Anton on 18.02.16.
 */

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository repository;

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) {
        Objects.requireNonNull(email, "Email must not be empty");
        return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(User user) {
        repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        repository.save(UserUtil.updateFromTo(user, userTo));
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        repository.save(user);
    }

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email.toLowerCase());

        if (u == null) {
            throw new UsernameNotFoundException("User " + email + "is not found");
        }

        return new LoggedUser(u);
    }
}
