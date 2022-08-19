package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.userDTOs.ChangeUsernameDTO;
import com.firstownproject.FirstProject.model.dto.userDTOs.UserProfileDTO;

import com.firstownproject.FirstProject.model.dto.userDTOs.UserRegisterDTO;
import com.firstownproject.FirstProject.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("newUsername")
    public void initUserModel(Model model) {
        model.addAttribute("newUsername", new ChangeUsernameDTO());
    }


    @GetMapping("/profile")
    public String getProfile(Principal principal, Model model){

        String username = principal.getName();

        UserProfileDTO currentUser = userService.getCurrentUserForProfile(username);

        model.addAttribute("currentUser", currentUser);

        return "profile";
    }




    @GetMapping("/profile/edit-username")
    public String changeUsername(){
        return "edit-username";
    }

    @PostMapping("/profile/edit-username")
    public String changeUsername(@Valid ChangeUsernameDTO changeUsernameDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Principal principal,
                                 Model newUsername){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("newUsername", changeUsernameDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newUsername", bindingResult);

            return "redirect:/profile/edit-username";
        }

        userService.editUsername(principal, changeUsernameDTO);

        return "redirect:/profile";
    }
}
