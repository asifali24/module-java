package com.module1.firstModule.exceptions;

public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
