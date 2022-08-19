package com.firstownproject.FirstProject.model.dto.userDTOs;

import com.firstownproject.FirstProject.model.validation.UniqueUsername;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ChangeUsernameDTO {

    @NotEmpty(message = "Username cannot be empty.")
    @Size(min = 3,max = 20,message = "Username must be between 3 and 20 characters.")
    @UniqueUsername(message = "Username already exists.")
    private String username;

    public String getUsername() {
        return username;
    }

    public ChangeUsernameDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}
