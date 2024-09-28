package com.example.api.domain.services;

import com.example.api.domain.services.vo.Country;
import com.example.api.infrastructure.providers.CountriesProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CountryServiceTests {

    @Mock
    private CountriesProvider countriesProvider;

    @InjectMocks
    private CountryService countryService;

    private List<Country> mockCountries;

    private final String country = "france";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockCountries = Arrays.asList(
                new Country()
        );
    }


    @Test
    public void shouldGetCountry() {
        when(countriesProvider.getCountry(country)).thenReturn(mockCountries);

        List<Country> result = countryService.getCountry(country);

        assertEquals(mockCountries, result);
    }
}
