package com.firstownproject.FirstProject.service;


import com.firstownproject.FirstProject.model.dto.EventDTO;
import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.respository.EventRepository;
import com.firstownproject.FirstProject.respository.TownRepository;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public EventService(EventRepository eventRepository, UserRepository userRepository, TownRepository townRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.townRepository = townRepository;
    }


    public void addEvent(EventDTO eventAddDto,UserDetails userDetails) throws ParseException {
        EventEntity newEvent = new EventEntity().
                setCountry(eventAddDto.getCountry()).
                setTown(eventAddDto.getTown()).
                setEventType(eventAddDto.getType()).
                setEventPlace(eventAddDto.getPlace()).
                setAddress(eventAddDto.getAddress()).
                setDescription(eventAddDto.getDescription()).
                setDate(formatter.parse(eventAddDto.getDate()));

        UserEntity currentUser = userRepository.findByUsername(userDetails.getUsername()).get();

        newEvent.setOrganizer(currentUser);

        eventRepository.save(newEvent);
    }
}
