package com.anton.project.web.exception;

import com.anton.project.LoggedUser;
import com.anton.project.LoggerWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anton on 22.02.16.
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private static final LoggerWrapper LOG = LoggerWrapper.get(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    ModelAndView handleError(HttpServletRequest req, Exception e) {
        LOG.error("Exception at request " + req.getRequestURL());
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
