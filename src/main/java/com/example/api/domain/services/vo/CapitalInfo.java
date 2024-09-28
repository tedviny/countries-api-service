package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CapitalInfo {
    @JsonProperty("latlng")
    private List<Double> latlng;

}
