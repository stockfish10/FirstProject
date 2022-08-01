package com.firstownproject.FirstProject.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "towns")
public class TownEntity extends BaseEntity{

    private String name;

    private String description;

    @ManyToOne
    private CountryEntity country;

    @OneToMany
    private List<EventEntity> events = new ArrayList<>();

    public String getName() {
        return name;
    }

    public TownEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TownEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public TownEntity setCountry(CountryEntity city) {
        this.country = city;
        return this;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public TownEntity setEvents(List<EventEntity> events) {
        this.events = events;
        return this;
    }
}
