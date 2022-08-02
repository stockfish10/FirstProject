package com.firstownproject.FirstProject.respository;

import com.firstownproject.FirstProject.model.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
