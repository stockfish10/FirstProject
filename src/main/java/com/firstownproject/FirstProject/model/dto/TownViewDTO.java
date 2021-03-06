package com.firstownproject.FirstProject.model.dto;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import com.firstownproject.FirstProject.model.entity.EventEntity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class TownViewDTO {

    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public TownViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TownViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TownViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
