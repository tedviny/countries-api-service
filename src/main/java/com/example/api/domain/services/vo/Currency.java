package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
}
