package com.firstownproject.FirstProject.respository;

import com.firstownproject.FirstProject.model.entity.TownEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TownRepository extends JpaRepository<TownEntity,Long> {
    List<TownEntity> findTownEntitiesByCountryId(Long id);

    TownEntity findTownById(Long townId);
}
