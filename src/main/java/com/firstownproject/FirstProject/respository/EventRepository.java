package com.firstownproject.FirstProject.respository;

import com.firstownproject.FirstProject.model.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
    Optional<EventEntity> findTownByTownId(Long id);
}
