package com.spring.socialmediarestapp.errors;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Data
public class ResourceNotFoundException extends RuntimeException {
    private String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
