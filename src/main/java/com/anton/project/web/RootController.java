package com.anton.project.web;

import com.anton.project.LoggedUser;
import com.anton.project.to.UserTo;
import com.anton.project.util.UserUtil;
import com.anton.project.web.user.AbstractUserController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by Anton on 18.02.16.
 */

@Controller
public class RootController extends AbstractUserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:meals";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String mealList() {
        return "mealList";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {

        model.put("error", error);
        model.put("message", message);

        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "profile";
    }

    @RequestMapping(value= "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (!result.hasErrors()) {
            userTo.setId(LoggedUser.id());
            super.update(userTo);
            LoggedUser.get().update(userTo);
            status.setComplete();

            return "redirect:meals";
        }

        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);

        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (!result.hasErrors()) {
            super.create(UserUtil.createFromTo(userTo));
            status.setComplete();
            return "redirect:login";
        }

        model.addAttribute("register", true);
        return "profile";
    }
}


















