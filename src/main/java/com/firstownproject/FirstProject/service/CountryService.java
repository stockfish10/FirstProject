package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.exceptions.CountryNotFoundException;
import com.firstownproject.FirstProject.model.dto.CountryViewDTO;
import com.firstownproject.FirstProject.model.dto.TownViewDTO;
import com.firstownproject.FirstProject.model.entity.CountryEntity;
import com.firstownproject.FirstProject.model.entity.TownEntity;
import com.firstownproject.FirstProject.respository.CountryRepository;
import com.firstownproject.FirstProject.respository.TownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryViewDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private CountryViewDTO map(CountryEntity co) {
        CountryViewDTO newCountryView = new CountryViewDTO();

        return newCountryView.setId(co.getId())
                .setInformation(co.getInformation())
                .setName(co.getName())
                .setPicture(co.getPicture());
    }

    public CountryViewDTO getCountry(Long id){
        return countryRepository.findById(id)
                .map(country -> new CountryViewDTO()
                        .setName(country.getName())
                        .setId(country.getId())
                        .setPicture(country.getPicture())
                        .setInformation(country.getInformation())).
                orElseThrow(CountryNotFoundException::new);
    }

    private TownViewDTO mapTown(TownEntity town) {
        TownViewDTO townDto = new TownViewDTO();

        return townDto.setId(town.getId()).
                setName(town.getName()).
                setDescription(town.getDescription());
    }
}


