package com.firstownproject.FirstProject.service;


import com.firstownproject.FirstProject.respository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


}
