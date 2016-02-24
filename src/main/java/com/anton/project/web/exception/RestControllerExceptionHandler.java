package com.anton.project.web.exception;

import com.anton.project.LoggerWrapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Anton on 22.02.16.
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {
    private static final LoggerWrapper LOG = LoggerWrapper.get(RestControllerExceptionHandler.class);
}
