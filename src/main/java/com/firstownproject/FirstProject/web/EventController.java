package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.EventDTO;
import com.firstownproject.FirstProject.model.dto.UserRegisterDTO;
import com.firstownproject.FirstProject.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ModelAttribute("eventModel")
    public void initUserModel(Model model) {
        model.addAttribute("eventModel", new EventDTO());
    }

    @GetMapping("/events/add")
    public String addEvent(){
        return "add-event";
    }


//    @PostMapping("/events/add")
//    public String addEvent(@Valid EventDTO eventModel,
//                           BindingResult bindingResult,
//                           RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("eventModel", eventModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eventModel", bindingResult);
//
//            return "redirect:/add-event";
//        }
//
//        return "redirect:/";
//    }



//    @GetMapping("/town{id}/events")
//    public String getAllEventsForTown(@PathVariable Long id, Model model) {
//
//
//        return "/events";
//    }
}
