package com.firstownproject.FirstProject.model.dto.userDTOs;


import com.firstownproject.FirstProject.model.dto.eventDTOs.EventForProfileDTO;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventShowDTO;

import java.util.List;

public class UserProfileDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private List<EventForProfileDTO> events;

    public String getUsername() {
        return username;
    }

    public UserProfileDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserProfileDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<EventForProfileDTO> getEvents() {
        return events;
    }

    public UserProfileDTO setEvents(List<EventForProfileDTO> events) {
        this.events = events;
        return this;
    }
}
