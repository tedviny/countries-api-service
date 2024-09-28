package com.example.api.application.controllers;

import com.example.api.domain.services.CountriesService;
import com.example.api.domain.services.CountryService;
import com.example.api.domain.services.vo.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {


    private final CountriesService countriesService;
    private final CountryService countryService;

    @Autowired
    public CountryController(CountriesService countriesService, CountryService countryService){
        this.countriesService = countriesService;
        this.countryService = countryService;
    }

    @GetMapping("{country}")
    public ResponseEntity<List<Country>> getCountry(@PathVariable String country) {
        List<Country> countries = countryService.getCountry(country);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
