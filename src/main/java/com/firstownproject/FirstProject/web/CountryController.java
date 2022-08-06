package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.countryDTOs.CountryDTO;
import com.firstownproject.FirstProject.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/{id}")
    public String getCountry(@PathVariable Long id,
                             Model model){
        CountryDTO country = countryService.getCountry(id);
        model.addAttribute("country", country);


        return "country";
    }
}
