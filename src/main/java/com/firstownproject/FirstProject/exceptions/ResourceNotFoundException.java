package com.firstownproject.FirstProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final Long objectId;

    public ResourceNotFoundException(Long objectId) {
        this.objectId = objectId;
    }

    public Long getObjectId() {
        return objectId;
    }
}
