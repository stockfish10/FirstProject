package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.UserRegisterDTO;
import com.firstownproject.FirstProject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO) {
        userService.registerAndLogin(userRegisterDTO);
        return "redirect:/";
    }

}
