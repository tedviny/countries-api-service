package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Car {
    @JsonProperty("signs")
    private List<String> signs;
    @JsonProperty("side")
    private String side;
}
