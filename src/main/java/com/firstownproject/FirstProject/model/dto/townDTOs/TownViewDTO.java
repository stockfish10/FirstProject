package com.firstownproject.FirstProject.model.dto.townDTOs;

public class TownViewDTO {

    private Long id;

    private String name;

    private String description;

    private String picture;

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

    public String getPicture() {
        return picture;
    }

    public TownViewDTO setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
