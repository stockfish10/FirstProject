package com.firstownproject.FirstProject.model.entity;

import com.firstownproject.FirstProject.model.enums.EventPlaceEnum;
import com.firstownproject.FirstProject.model.enums.EventTypeEnum;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany
    private List<UserEntity> organizer = new ArrayList<>();

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

    public List<UserEntity> getOrganizer() {
        return organizer;
    }

    public EventEntity setOrganizer(List<UserEntity> organizer) {
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
}
