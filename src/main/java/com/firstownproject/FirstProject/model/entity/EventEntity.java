package com.firstownproject.FirstProject.model.entity;

import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class EventEntity extends BaseEntity {

    @ManyToOne
    private CountryEntity country;

    @ManyToOne
    private TownEntity town;

    @Enumerated(EnumType.STRING)
    private EventTypeEnum eventType;

    private String description;

    @Enumerated(EnumType.STRING)
    private EventPlaceEnum eventPlace;

    private String address;

    @ManyToOne
    private UserEntity organizer;

    private String picture;

    private Date date;

    @ManyToMany
    private List<UserEntity> participants = new ArrayList<>();

    public CountryEntity getCountry() {
        return country;
    }

    public EventEntity setCountry(CountryEntity country) {
        this.country = country;
        return this;
    }

    public TownEntity getTown() {
        return town;
    }

    public EventEntity setTown(TownEntity town) {
        this.town = town;
        return this;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public EventEntity setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EventPlaceEnum getEventPlace() {
        return eventPlace;
    }

    public EventEntity setEventPlace(EventPlaceEnum eventPlace) {
        this.eventPlace = eventPlace;
        return this;
    }

    public UserEntity getOrganizer() {
        return organizer;
    }

    public EventEntity setOrganizer(UserEntity organizer) {
        this.organizer = organizer;
        return this;
    }

    public List<UserEntity> getParticipants() {
        return participants;
    }

    public EventEntity setParticipants(List<UserEntity> participants) {
        this.participants = participants;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EventEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public EventEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public EventEntity setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
