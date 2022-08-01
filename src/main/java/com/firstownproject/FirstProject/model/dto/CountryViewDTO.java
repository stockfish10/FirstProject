package com.firstownproject.FirstProject.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryViewDTO {

    private Long id;

    private String name;

    private String information;

    private String picture;

    public Long getId() {
        return id;
    }

    public CountryViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getInformation() {
        return information;
    }

    public CountryViewDTO setInformation(String information) {
        this.information = information;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public CountryViewDTO setPicture(String picture) {
        this.picture = picture;
        return this;
    }

}
