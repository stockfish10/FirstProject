package com.firstownproject.FirstProject.model.dto.eventDTOs;

import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventDTO {

    @NotNull
    @Min(1)
    private Long townId;

    @NotEmpty
    private String eventName;

    @NotNull
    private EventTypeEnum type;

    @NotNull
    private EventPlaceEnum place;

    @NotEmpty
    @Size(min = 50,max = 5000,message = "Must be between 50 and 5000 characters long.")
    private String description;

    @NotEmpty
    @Size(min = 5, max = 50)
    private String address;

    @NotEmpty
    private String date;


    public EventTypeEnum getType() {
        return type;
    }

    public EventDTO setType(EventTypeEnum type) {
        this.type = type;
        return this;
    }

    public EventPlaceEnum getPlace() {
        return place;
    }

    public EventDTO setPlace(EventPlaceEnum place) {
        this.place = place;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EventDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EventDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDate() {
        return date;
    }

    public EventDTO setDate(String date) {
        this.date = date;
        return this;
    }

    public String getEventName() {
        return eventName;
    }

    public EventDTO setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Long getTownId() {
        return townId;
    }

    public EventDTO setTownId(Long townId) {
        this.townId = townId;
        return this;
    }
}
