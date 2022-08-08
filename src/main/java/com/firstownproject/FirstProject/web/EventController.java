package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.eventDTOs.EventDTO;
import com.firstownproject.FirstProject.model.dto.eventDTOs.EventShowDTO;
import com.firstownproject.FirstProject.service.CountryService;
import com.firstownproject.FirstProject.service.EventService;
import com.firstownproject.FirstProject.service.TownService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

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
}
