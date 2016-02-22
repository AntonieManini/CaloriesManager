package com.anton.project.web.exception;

import com.anton.project.LoggedUser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anton on 22.02.16.
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handleError(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView("exception/exception");
        mav.addObject("exception", e);
        LoggedUser loggedUser = LoggedUser.safeGet();

        // Interceptor is not invoked, put userTo
        if (loggedUser != null) {
            mav.addObject("userTo", loggedUser.getUserTo());
        }
        return mav;
    }
}
