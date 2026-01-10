package com.example.demo.exception;

import org.jspecify.annotations.Nullable;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("User not found: " + id);
    }

}
