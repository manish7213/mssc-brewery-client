package com.sfg.msscbreweryclient.client;

import com.sfg.msscbreweryclient.model.BeerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    @Value("${com.sfg.apiHost}")
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setHostName(String hostName) {
        this.apiHost = hostName;
    }

    public BeerDto getBeerById(UUID uuid) {

        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {

        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {

        restTemplate.put(apiHost + BEER_PATH_V1 + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + uuid.toString());
    }
}
