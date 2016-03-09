package com.anton.project.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Anton on 18.02.16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No data found")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
