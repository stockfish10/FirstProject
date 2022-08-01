package com.firstownproject.FirstProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {

    @GetMapping("/events/town{id}")
    public String getAllEventsForTown(@PathVariable Long id, Model model) {


        return "/events";
    }
}
