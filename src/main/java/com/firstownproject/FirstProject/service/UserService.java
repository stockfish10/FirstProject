package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.dto.eventDTOs.EventForProfileDTO;
import com.firstownproject.FirstProject.model.dto.userDTOs.UserProfileDTO;
import com.firstownproject.FirstProject.model.dto.userDTOs.UserRegisterDTO;
import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,
                       UserDetailsService userDetailsService,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.mapper = new ModelMapper();
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = mapper.map(userRegisterDTO, UserEntity.class)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);

        login(newUser);
    }

    private void login(UserEntity userEntity) {
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userEntity.getUsername());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );
        SecurityContextHolder.
                getContext().
                setAuthentication(auth);

    }

    public UserProfileDTO getCurrentUserForProfile(String username) {
        UserEntity currUser = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException(username + " was not found."));

        UserProfileDTO currentUserForProfile = new UserProfileDTO();

        return currentUserForProfile.
                setUsername(currUser.getUsername()).
                setFirstName(currUser.getFirstName()).
                setLastName(currUser.getLastName()).
                setEmail(currUser.getEmail()).
                setEvents(currUser.
                        getEvents().
                        stream().
                        map(this::map).
                        collect(Collectors.toList()));
    }


    private EventForProfileDTO map(EventEntity event) {
        EventForProfileDTO eventForProfileDTO = new EventForProfileDTO();

        return  eventForProfileDTO.
                setId(event.getId()).
                setName(event.getName()).
                setTown(event.getTown().getName()).
                setCountry(event.getCountry().getName());
    }
}
