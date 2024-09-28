package com.example.api.infrastructure.providers;

import com.example.api.ApplicationConfig;
import com.example.api.domain.services.vo.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CountriesProvider {

    private final Logger logger = Logger.getLogger(CountriesProvider.class.getName());

    private final ApplicationConfig applicationConfig;
    private final WebClient webClient;

    @Autowired
    public CountriesProvider(ApplicationConfig applicationConfig, WebClient.Builder webClientBuilder){
        this.applicationConfig = applicationConfig;
        this.webClient = webClientBuilder.baseUrl(applicationConfig.getApiUrl()).build();
    }

    public List<Country> getCountries() {
        logger.info("Calling API: " + applicationConfig.getApiUrl());
        return webClient.get()
                .uri("/all")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Country>>() {})
                .block();
    }

    public List<Country> getCountry( String countryName){
        logger.info("Calling API: " + applicationConfig.getApiUrl() + "/name/" + countryName);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/name/{countryName}").build(countryName))
                .retrieve()
                .bodyToFlux(Country.class)
                .collectList()
                .block();

    }
}
