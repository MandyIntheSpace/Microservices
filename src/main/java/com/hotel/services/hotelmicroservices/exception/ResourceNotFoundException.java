package com.hotel.services.hotelmicroservices.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource not found in the server");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
