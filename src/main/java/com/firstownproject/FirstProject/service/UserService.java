package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.dto.UserRegisterDTO;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final AppUserDetailsService appUserDetailsService;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, AppUserDetailsService appUserDetailsService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.appUserDetailsService = appUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.mapper = new ModelMapper();
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = mapper.map(userRegisterDTO, UserEntity.class)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(newUser);

        UserDetails userDetails = appUserDetailsService.loadUserByUsername(newUser.getUsername());

        login(newUser);
    }

    private void login(UserEntity userEntity) {
        UserDetails userDetails =
                appUserDetailsService.loadUserByUsername(userEntity.getUsername());

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

}
