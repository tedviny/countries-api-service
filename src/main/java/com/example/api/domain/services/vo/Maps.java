package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maps {
    @JsonProperty("googleMaps")
    private String googleMaps;
    @JsonProperty("openStreetMaps")
    private String openStreetMaps;
}
