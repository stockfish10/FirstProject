package com.firstownproject.FirstProject.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class CountryEntity extends BaseEntity{

    private String name;

    private String information;

    private String picture;

    @OneToMany
    private List<TownEntity> towns;

    public String getName() {
        return name;
    }

    public CountryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getInformation() {
        return information;
    }

    public CountryEntity setInformation(String description) {
        this.information = description;
        return this;
    }

    public List<TownEntity> getTowns() {
        return towns;
    }

    public CountryEntity setTowns(List<TownEntity> towns) {
        this.towns = towns;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public CountryEntity setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
