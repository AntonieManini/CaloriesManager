package com.anton.project.util.exception;

import org.springframework.validation.BindingResult;

/**
 * Created by Anton on 19.02.16.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(BindingResult result) {
        super(getDescription(result));
    }

    private static String getDescription(BindingResult result) {
        return "";
    }
}
