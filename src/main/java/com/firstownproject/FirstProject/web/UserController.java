package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.userDTOs.UserProfileDTO;
import com.firstownproject.FirstProject.model.entity.UserEntity;
import com.firstownproject.FirstProject.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(Principal principal, Model model){

        String username = principal.getName();

        UserProfileDTO currentUser = userService.getCurrentUserForProfile(username);

        model.addAttribute("currentUser", currentUser);

        return "profile";
    }
}
