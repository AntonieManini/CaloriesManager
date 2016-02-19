package com.anton.project.web.user;

import com.anton.project.model.User;
import com.anton.project.to.UserTo;
import com.anton.project.util.UserUtil;
import com.anton.project.util.exception.ValidationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Anton on 19.02.16.
 */

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        status.setComplete();

        if (userTo.getId() == 0) {
            super.create(UserUtil.createFromTo(userTo));
        }
        else {
            super.update(userTo);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enabled(int id, boolean enabled) {
        super.enable(id, enabled);
    }
}
