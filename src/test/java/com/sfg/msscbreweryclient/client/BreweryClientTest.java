package com.sfg.msscbreweryclient.client;

import com.sfg.msscbreweryclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient client;

    @Test
    void getBeerByIdTest() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeerTest() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeerTest() {
        client.deleteBeer(UUID.randomUUID());
    }
}