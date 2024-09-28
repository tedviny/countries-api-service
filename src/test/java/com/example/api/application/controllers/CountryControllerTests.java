package com.example.api.application.controllers;

import com.example.api.TestUtils;
import com.example.api.domain.services.CountriesService;
import com.example.api.domain.services.CountryService;
import com.example.api.domain.services.vo.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    private List<Country> mockCountries;

    private final String country = "france";

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        ObjectMapper objectMapper = new ObjectMapper();
        mockCountries = objectMapper.readValue(
                TestUtils.readJsonFile("src/test/resources/country/country_mock.json"),
                new TypeReference<List<Country>>() {}
        );

    }

    @Test
    public void shouldReturnCountryInformation() throws Exception {

        when(countryService.getCountry(country)).thenReturn(mockCountries);

        mockMvc.perform(get("/country/{country}", country)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldThrowAnErrorToReturnCountryInformation() throws Exception {

        when(countryService.getCountry(country)).thenThrow(new RuntimeException("No country founded"));

        mockMvc.perform(get("/country/country/{country}", country)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

}
