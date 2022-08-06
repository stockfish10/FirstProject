package com.firstownproject.FirstProject.model.dto.countryDTOs;

import com.firstownproject.FirstProject.model.dto.townDTOs.TownViewDTO;

import java.util.ArrayList;
import java.util.List;

public class CountryDTO {

    private Long id;

    private String name;

    private String information;

    private String picture;

    private List<TownViewDTO> towns = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public CountryDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getInformation() {
        return information;
    }

    public CountryDTO setInformation(String information) {
        this.information = information;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public CountryDTO setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public List<TownViewDTO> getTowns() {
        return towns;
    }

    public CountryDTO setTowns(List<TownViewDTO> towns) {
        this.towns = towns;
        return this;
    }
}
