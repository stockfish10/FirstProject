package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.model.entity.UserRoleEntity;
import com.firstownproject.FirstProject.model.user.MyAppUser;
import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() ->
                        new UsernameNotFoundException
                                (String.format("User with username %s not found!",username)));
    }

    private UserDetails map(UserEntity userEntity){

        return new MyAppUser(userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getUserRoles().
                        stream().
                        map(this::map).
                        toList());
    }

    private GrantedAuthority map(UserRoleEntity userRole){
        return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
