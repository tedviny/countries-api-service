package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Name {
    @JsonProperty("common")
    private String common;
    @JsonProperty("official")
    private String official;
    @JsonProperty("nativeName")
    private Map<String, NativeName> nativeName;
}
