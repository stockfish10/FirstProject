package com.firstownproject.FirstProject.model.dto.eventDTOs;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import com.firstownproject.FirstProject.model.entity.TownEntity;

import javax.validation.constraints.NotNull;

public class EventForProfileDTO {

    private Long id;

    private String name;

    private String country;

    private String town;

    public Long getId() {
        return id;
    }

    public EventForProfileDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EventForProfileDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public EventForProfileDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getTown() {
        return town;
    }

    public EventForProfileDTO setTown(String town) {
        this.town = town;
        return this;
    }
}
