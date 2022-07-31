package com.firstownproject.FirstProject.respository;

import com.firstownproject.FirstProject.model.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
