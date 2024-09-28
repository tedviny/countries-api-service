package com.example.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${restcountries.url}")
    private String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }
}
