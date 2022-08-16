package com.firstownproject.FirstProject.service;


import com.firstownproject.FirstProject.model.dto.eventDTOs.EventDTO;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventShowDTO;
import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.respository.CountryRepository;
import com.firstownproject.FirstProject.respository.EventRepository;
import com.firstownproject.FirstProject.respository.TownRepository;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final CountryRepository countryRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public EventService(EventRepository eventRepository, UserRepository userRepository, TownRepository townRepository, CountryRepository countryRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
    }


    public void addEvent(EventDTO eventAddDto, String organizerUsername) throws ParseException {
        EventEntity newEvent = new EventEntity().
                setCountry(countryRepository.findByTownsId(eventAddDto.getTownId())).
                setTown(townRepository.findTownById(eventAddDto.getTownId())).
                setEventType(eventAddDto.getType()).
                setEventPlace(eventAddDto.getPlace()).
                setAddress(eventAddDto.getAddress()).
                setDescription(eventAddDto.getDescription()).
                setDate(formatter.parse(eventAddDto.getDate())).
                setPicture(setEventPicture(eventAddDto.getType().toString())).
                setName(eventAddDto.getEventName());

        UserEntity currentUser = userRepository.findByUsername(organizerUsername).get();


        newEvent.setOrganizer(currentUser);

        eventRepository.save(newEvent);
    }

    public List<EventShowDTO> getEventsForTown(Long id) {
        return eventRepository.findTownByTownId(id).
                stream().
                map(this::map).
                collect(Collectors.toList());

    }

    private EventShowDTO map(EventEntity eventEntity) {
        EventShowDTO newEvent = new EventShowDTO();

        return newEvent.
                setCountry(eventEntity.getCountry().getName()).
                setTown(eventEntity.getTown().getName()).
                setEventType(eventEntity.getEventType().toString()).
                setEventPlace(eventEntity.getEventPlace().toString()).
                setAddress(eventEntity.getAddress()).
                setOrganizer(eventEntity.getOrganizer().getFullName()).
                setDescription(eventEntity.getDescription()).
                setDate(eventEntity.getDate()).
                setPicture(eventEntity.getPicture())
                .setName(eventEntity.getName());
    }

    public List<EventShowDTO> getAllEvents() {
        return eventRepository.findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    public Page<EventShowDTO> getAllEvents(Pageable pageable) {
        return eventRepository.
                findAll(pageable).
                map(this::map);
    }

    public String setEventPicture(String eventType) {
        String type = eventType.toLowerCase();

        return switch (type) {
            case "music" -> "/images/music.jpg";
            case "health" -> "/images/health.jpg";
            case "hobbies" -> "/images/hobbies.jpg";
            case "business" -> "/images/business.jpg";
            case "foodanddrink" -> "/images/food.jpg";
            case "sportsandfitness" -> "/images/sports.jpg";
            case "travelandoutdoor" -> "/images/travel.jpg";
            default -> "";
        };
    }
}