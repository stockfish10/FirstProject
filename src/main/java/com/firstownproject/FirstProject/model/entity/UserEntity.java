package com.firstownproject.FirstProject.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private List<EventEntity> events;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<EventEntity> eventsToAttend;

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public UserEntity setEvents(List<EventEntity> events) {
        this.events = events;
        return this;
    }

    public List<EventEntity> getEventsToAttend() {
        return eventsToAttend;
    }

    public UserEntity setEventsToAttend(List<EventEntity> eventsToAttend) {
        this.eventsToAttend = eventsToAttend;
        return this;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public UserEntity setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
