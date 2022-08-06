package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.dto.townDTOs.TownViewDTO;
import com.firstownproject.FirstProject.model.entity.TownEntity;
import com.firstownproject.FirstProject.respository.TownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownService {

    private final TownRepository townRepository;

    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    public List<TownViewDTO> getTownsForCountry(Long id) {
        return townRepository.findTownEntitiesByCountry_Id(id).
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    private TownViewDTO map(TownEntity town){
        TownViewDTO townDTO = new TownViewDTO();

        return townDTO.
                setId(town.getId()).
                setName(town.getName()).
                setDescription(town.getDescription());
    }
}
