package com.example.api.application.controllers;

import com.example.api.domain.services.CountriesService;
import com.example.api.domain.services.vo.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountriesController {

    private final CountriesService countriesService;

    @Autowired
    public CountriesController(CountriesService countriesService){
        this.countriesService = countriesService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> getCountries(){
        List<Country> countries = countriesService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }


}
