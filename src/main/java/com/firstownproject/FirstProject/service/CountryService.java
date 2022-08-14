package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.exceptions.CountryNotFoundException;
import com.firstownproject.FirstProject.model.dto.countryDTOs.CountryDTO;
import com.firstownproject.FirstProject.model.dto.townDTOs.TownViewDTO;
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
    private final TownRepository townRepository;

    public CountryService(CountryRepository countryRepository, TownRepository townRepository) {
        this.countryRepository = countryRepository;
        this.townRepository = townRepository;
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private CountryDTO map(CountryEntity co) {
        CountryDTO newCountryView = new CountryDTO();

        return newCountryView.setId(co.getId())
                .setInformation(co.getInformation())
                .setName(co.getName())
                .setPicture(co.getPicture())
                .setTowns(getTownsForCountry(co));
    }

    public CountryDTO getCountry(Long id){
        return countryRepository.findById(id)
                .map(country -> new CountryDTO()
                        .setName(country.getName())
                        .setId(country.getId())
                        .setPicture(country.getPicture())
                        .setInformation(country.getInformation()).
                        setTowns(getTownsForCountry(country))).
                orElseThrow(CountryNotFoundException::new);
    }

    private List<TownViewDTO> getTownsForCountry(CountryEntity country) {
        return townRepository.
                findTownEntitiesByCountryId(country.getId()).
                stream().
                map(this::mapTown).
                collect(Collectors.toList());
    }

    private TownViewDTO mapTown(TownEntity town) {
        TownViewDTO townDto = new TownViewDTO();

        return townDto.setId(town.getId()).
                setName(town.getName()).
                setDescription(town.getDescription()).
                setPicture(town.getPicture());
    }
}


