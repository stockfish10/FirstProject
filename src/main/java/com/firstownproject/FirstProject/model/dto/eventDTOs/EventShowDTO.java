package com.firstownproject.FirstProject.model.dto.eventDTOs;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import com.firstownproject.FirstProject.model.entity.TownEntity;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventShowDTO {


    private String country;

    private String town;

    private String eventType;

    private String description;

    private String eventPlace;

    private String address;

    private String organizer;

    private String picture;

    private Date date;


    public String getCountry() {
        return country;
    }

    public EventShowDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getTown() {
        return town;
    }

    public EventShowDTO setTown(String town) {
        this.town = town;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public EventShowDTO setEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventShowDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public EventShowDTO setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EventShowDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getOrganizer() {
        return organizer;
    }

    public EventShowDTO setOrganizer(String organizer) {
        this.organizer = organizer;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public EventShowDTO setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public EventShowDTO setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
