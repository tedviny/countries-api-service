package com.example.api.domain.services.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Country {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("tld")
    private List<String> tld;
    @JsonProperty("cca2")
    private String cca2;
    @JsonProperty("ccn3")
    private String ccn3;
    @JsonProperty("cca3")
    private String cca3;
    @JsonProperty("independent")
    private boolean independent;
    @JsonProperty("status")
    private String status;
    @JsonProperty("unMember")
    private boolean unMember;
    @JsonProperty("currencies")
    private Map<String, Currency> currencies;
    @JsonProperty("idd")
    private Idd idd;
    @JsonProperty("capital")
    private List<String> capital;
    @JsonProperty("altSpellings")
    private List<String> altSpellings;
    @JsonProperty("region")
    private String region;
    @JsonProperty("languages")
    private Map<String, String> languages;
    @JsonProperty("translations")
    private Map<String, Translation> translations;
    @JsonProperty("latlng")
    private List<Double> latlng;
    @JsonProperty("landlocked")
    private boolean landlocked;
    @JsonProperty("area")
    private double area;
    @JsonProperty("demonyms")
    private Demonyms demonyms;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("maps")
    private Maps maps;
    @JsonProperty("population")
    private int population;
    @JsonProperty("car")
    private Car car;
    @JsonProperty("timezones")
    private List<String> timezones;
    @JsonProperty("continents")
    private List<String> continents;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("coatOfArms")
    private CoatOfArms coatOfArms;
    @JsonProperty("startOfWeek")
    private String startOfWeek;
    @JsonProperty("capitalInfo")
    private CapitalInfo capitalInfo;
}
