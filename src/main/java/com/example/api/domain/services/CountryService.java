package com.example.api.domain.services;

import com.example.api.domain.services.vo.Country;
import com.example.api.infrastructure.providers.CountriesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountriesProvider countriesProvider;

    @Autowired
    public CountryService(CountriesProvider countriesProvider) {
        this.countriesProvider = countriesProvider;
    }


    public List<Country> getCountry(String countryName){
        return countriesProvider.getCountry(countryName);
    }

}
