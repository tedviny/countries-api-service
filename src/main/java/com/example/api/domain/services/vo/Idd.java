package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Idd {
    @JsonProperty("root")
    private String root;
    @JsonProperty("suffixes")
    private List<String> suffixes;
}
