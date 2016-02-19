package com.anton.project.web.user;

import com.anton.project.model.User;
import com.anton.project.service.UserService;
import com.anton.project.to.UserTo;
import com.anton.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Anton on 18.02.16.
 */
public abstract class AbstractUserController {

    @Autowired
    private UserService service;

    public List<User> getAll() {
        return service.getAll();
    }

    public User get(int id) {
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);

        return service.save(UserUtil.prepareToSave(user));
    }

    public void delete(int id) {
        service.delete(id);
    }

    public void update(User user, int id) {
        user.setId(id);

        service.update(UserUtil.prepareToSave(user));
    }

    public void update(UserTo userTo) {
        service.update(userTo);
    }

    public User getByEmail(String email) {
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        service.enable(id, enabled);
    }
}
