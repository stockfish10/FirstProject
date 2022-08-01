package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.CountryViewDTO;
import com.firstownproject.FirstProject.model.dto.TownViewDTO;
import com.firstownproject.FirstProject.service.CountryService;
import com.firstownproject.FirstProject.service.TownService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CountryController {

    private final CountryService countryService;
    private final TownService townService;

    public CountryController(CountryService countryService, TownService townService) {
        this.countryService = countryService;
        this.townService = townService;
    }

    @GetMapping("/country/{id}")
    public String getCountry(@PathVariable Long id,
                             Model model){
        CountryViewDTO country = countryService.getCountry(id);
        List<TownViewDTO> townsForCountry = townService.getTownsForCountry(id);
        model.addAttribute("country", country);
        model.addAttribute("towns", townsForCountry);


        return "country";
    }
}
