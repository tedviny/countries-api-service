package com.example.api.application.controllers;

import com.example.api.TestUtils;
import com.example.api.domain.services.CountriesService;
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
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CountriesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountriesService countriesService;

    private List<Country> mockCountries;

    @BeforeEach
    public void setUp() throws IOException{
        MockitoAnnotations.openMocks(this);
        ObjectMapper objectMapper = new ObjectMapper();
        mockCountries = objectMapper.readValue(
                TestUtils.readJsonFile("src/test/resources/countries/countries_mock.json"),
                new TypeReference<List<Country>>() {}
        );

    }

    @Test
    public void shouldReturnAllCountries() throws Exception {
        when(countriesService.getCountries()).thenReturn(mockCountries);

        mockMvc.perform(get("/countries/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name.common").value("South Georgia"))
                .andExpect(jsonPath("$[0].name.official").value("South Georgia and the South Sandwich Islands"))
                .andExpect(jsonPath("$[0].independent").value(false))
                .andExpect(jsonPath("$[0].languages.eng").value("English"))
                .andExpect(jsonPath("$[0].region").value("Antarctic"))
                .andExpect(jsonPath("$[0].capital[0]").value("King Edward Point"));


    }

    @Test
    public void shouldThrowClientErrorToGetCountries() throws Exception{
        when(countriesService.getCountries()).thenThrow(new RuntimeException("Client Error"));

        mockMvc.perform(get("/countries/all/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


}
