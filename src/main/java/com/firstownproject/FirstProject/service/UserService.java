package com.firstownproject.FirstProject.service;

import com.firstownproject.FirstProject.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
