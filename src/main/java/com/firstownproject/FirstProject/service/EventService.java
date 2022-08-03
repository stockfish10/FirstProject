package com.firstownproject.FirstProject.service;


import com.firstownproject.FirstProject.model.dto.EventDTO;
import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.respository.EventRepository;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }


    public void addEvent(EventDTO eventModel,UserDetails userDetails) {
        EventEntity newEvent = new EventEntity().
                setCountry(eventModel.getCountry()).
                setTown(eventModel.getTown()).
                setEventType(eventModel.getType()).
                setEventPlace(eventModel.getPlace()).
                setAddress(eventModel.getAddress()).
                setDescription(eventModel.getDescription());

        UserEntity currentUser = userRepository.findByUsername(userDetails.getUsername()).get();

        newEvent.setOrganizer(currentUser);

        eventRepository.save(newEvent);
    }
}
