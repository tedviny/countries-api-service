package com.example.api.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.api.domain.services.vo.Country;
import com.example.api.infrastructure.providers.CountriesProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class CountriesServiceTests {

    @Mock
    private CountriesProvider countriesProvider;

    @InjectMocks
    private CountriesService countriesService;

    private List<Country> mockCountries;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockCountries = Arrays.asList(
                new Country()
        );
    }


    @Test
    public void shouldGetAllCountries() {
        when(countriesProvider.getCountries()).thenReturn(mockCountries);

        List<Country> result = countriesService.getCountries();

        assertEquals(mockCountries, result);
    }
}
