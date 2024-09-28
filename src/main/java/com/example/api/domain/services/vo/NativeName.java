package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NativeName {
    @JsonProperty("official")
    private String official;
    @JsonProperty("common")
    private String common;

}
