package com.example.api.infrastructure.providers;

import com.example.api.ApplicationConfig;
import com.example.api.domain.services.vo.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CountriesProviderTests {
    @Mock
    private ApplicationConfig applicationConfig;

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private CountriesProvider countriesProvider;

    private List<Country> mockCountries;

    private String mockApiUrl = "https://www.api.com";

    private final String country = "france";


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockCountries = Arrays.asList(
                new Country()
        );

        when(applicationConfig.getApiUrl()).thenReturn(mockApiUrl);
        when(webClientBuilder.baseUrl(mockApiUrl)).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);

        countriesProvider = new CountriesProvider(applicationConfig, webClientBuilder);
    }

    @Test
    public void shouldGetAllCountriesFromApi() throws Exception {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("/all")).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(new ParameterizedTypeReference<List<Country>>() {}))
                .thenReturn(Mono.just(mockCountries));

        List<Country> result = countriesProvider.getCountries();

        assertEquals(mockCountries, result);
    }

    @Test
    public void
    ShouldThrowAnApiErrorToGetCountries() throws Exception {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri("/all")).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(new ParameterizedTypeReference<List<Country>>() {}))
                .thenReturn(Mono.error(new WebClientResponseException(500, "Internal Server Error", null, null, null)));

        WebClientResponseException exception = assertThrows(WebClientResponseException.class, () -> {
            countriesProvider.getCountries();
        });

        assertEquals(500, exception.getStatusCode().value());
    }

}
