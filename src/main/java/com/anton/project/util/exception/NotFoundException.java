package com.anton.project.util.exception;

/**
 * Created by Anton on 18.02.16.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
