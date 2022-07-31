package com.firstownproject.FirstProject.web;

import com.firstownproject.FirstProject.model.dto.CountryViewDTO;
import com.firstownproject.FirstProject.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CountryService countryService;

    public HomeController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String getAllCountries(Model model) {
        List<CountryViewDTO> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);

        return "index";
    }
}
