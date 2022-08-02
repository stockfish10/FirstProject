package com.firstownproject.FirstProject.model.dto;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import com.firstownproject.FirstProject.model.entity.TownEntity;
import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EventDTO {

    @NotNull
    private CountryEntity country;

    @NotNull
    private TownEntity town;

    @NotNull
    private String type;

    @NotNull
    private String place;

    @NotNull
    @Size(min = 50,max = 5000)
    private String description;

    @NotNull
    @Size(min = 5, max = 50)
    private String address;

    public CountryEntity getCountry() {
        return country;
    }

    public EventDTO setCountry(CountryEntity country) {
        this.country = country;
        return this;
    }

    public TownEntity getTown() {
        return town;
    }

    public EventDTO setTown(TownEntity town) {
        this.town = town;
        return this;
    }

    public String getType() {
        return type;
    }

    public EventDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public EventDTO setPlace(String place) {
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
}
