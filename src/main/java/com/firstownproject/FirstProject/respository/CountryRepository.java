package com.firstownproject.FirstProject.respository;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    CountryEntity findByTownsId(Long townId);
}
