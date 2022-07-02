package com.firstownproject.FirstProject.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class TownEntity extends BaseEntity{

    private String name;

    private String description;

    @ManyToOne
    private CountryEntity city;

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

    public CountryEntity getCity() {
        return city;
    }

    public TownEntity setCity(CountryEntity city) {
        this.city = city;
        return this;
    }
}
