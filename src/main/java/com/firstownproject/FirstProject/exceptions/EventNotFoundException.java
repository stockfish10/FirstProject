package com.firstownproject.FirstProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventNotFoundException extends RuntimeException{

    private final Long id;

    public EventNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
