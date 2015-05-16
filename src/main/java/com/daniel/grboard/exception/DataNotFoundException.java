package com.daniel.grboard.exception;

/**
 * Created by daniel on 15. 4. 20.
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
