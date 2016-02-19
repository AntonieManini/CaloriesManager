package com.anton.project;

import com.anton.project.model.User;
import com.anton.project.to.UserTo;
import com.anton.project.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.requireNonNull;

/**
 * Created by Anton on 18.02.16.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private UserTo userTo;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");

        return user;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public static int id() {
        return get().userTo.getId();
    }

    public static int getCaloriesPerDay() {
        return get().userTo.getCaloriesPerDay();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }
}

