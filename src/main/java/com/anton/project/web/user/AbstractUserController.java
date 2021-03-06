package com.anton.project.web.user;

import com.anton.project.LoggerWrapper;
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

    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        user.setId(null);
        LOG.info("create " + user);
        return service.save(UserUtil.prepareToSave(user));
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        user.setId(id);
        LOG.info("update " + user);
        service.update(UserUtil.prepareToSave(user));
    }

    public void update(UserTo userTo) {
        LOG.info("update " + userTo);
        service.update(userTo);
    }

    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        LOG.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }
}
