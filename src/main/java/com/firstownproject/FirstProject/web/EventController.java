package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.exceptions.EventNotFoundException;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventDTO;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventForProfileDTO;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventShowDTO;
import com.firstownproject.FirstProject.model.entity.EventEntity;
import com.firstownproject.FirstProject.service.CountryService;
import com.firstownproject.FirstProject.service.EventService;
import com.firstownproject.FirstProject.service.TownService;
import com.firstownproject.FirstProject.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@Controller
public class EventController {

    private final EventService eventService;
    private final CountryService countryService;
    private final TownService townService;
    private final UserService userService;

    public EventController(EventService eventService, CountryService countryService, TownService townService, UserService userService) {
        this.eventService = eventService;
        this.countryService = countryService;
        this.townService = townService;
        this.userService = userService;
    }

    @ModelAttribute("eventModel")
    public void initUserModel(Model model) {
        model.addAttribute("eventModel", new EventDTO());
    }

    @GetMapping("/events/add")
    public String addEvent(Model model){
        model.addAttribute("countries", countryService.getAllCountries());
        return "add-event";
    }


    @PostMapping("/events/add")
    public String addEvent(@Valid EventDTO eventModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal) throws ParseException {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("eventModel", eventModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eventModel", bindingResult);

            return "redirect:/events/add";
        }

        String username = principal.getName();

        eventService.addEvent(eventModel,username);
        return "redirect:/";
    }

    @GetMapping("/events")
    public String getAllEvents(Model model,
                               @PageableDefault(page = 0,size = 5)
                               Pageable pageable) {
        model.addAttribute("allEvents", eventService.getAllEvents(pageable));

        return "/all-events";
    }


    @GetMapping("/events/{id}/")
    public String getAllEventsForTown(@PathVariable("id") Long townId, Model model) {
        List<EventShowDTO> eventDTOs = eventService.getEventsForTown(townId);
        model.addAttribute("events", eventDTOs);

        return "/events";
    }

    @GetMapping("/events/{id}")
    public String addEventToList(@PathVariable("id") Long id, Principal principal) {
        EventEntity eventToAdd = eventService.getEvent(id);

        userService.addEventToUserList(principal,eventToAdd);

        return "redirect:/profile";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({EventNotFoundException.class})
    public ModelAndView onEventNotFound(EventNotFoundException enfe) {
        ModelAndView modelAndView = new ModelAndView("event-not-found");

        return modelAndView;
    }

}
