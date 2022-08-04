package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.EventDTO;
import com.firstownproject.FirstProject.service.CountryService;
import com.firstownproject.FirstProject.service.EventService;
import com.firstownproject.FirstProject.service.TownService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class EventController {

    private final EventService eventService;
    private final CountryService countryService;
    private final TownService townService;

    public EventController(EventService eventService, CountryService countryService, TownService townService) {
        this.eventService = eventService;
        this.countryService = countryService;
        this.townService = townService;
    }

    @ModelAttribute("eventModel")
    public void initUserModel(Model model) {
        model.addAttribute("eventModel", new EventDTO());
        model.addAttribute("countries", countryService.getAllCountries());
    }

    @GetMapping("/events/add")
    public String addEvent(){
        return "add-event";
    }


    @PostMapping("/events/add")
    public String addEvent(@Valid EventDTO eventModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) throws ParseException {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("eventModel", eventModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eventModel", bindingResult);

            return "redirect:/events/add";
        }

        eventService.addEvent(eventModel,userDetails);
        return "redirect:/";
    }



//    @GetMapping("/town{id}/events")
//    public String getAllEventsForTown(@PathVariable Long id, Model model) {
//
//
//        return "/events";
//    }
}
