package com.sfg.msscbreweryclient.client;

import com.sfg.msscbreweryclient.model.BeerDto;
import com.sfg.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;
    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Manish").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerTest() {
        CustomerDto dto = CustomerDto.builder().name("Manish").build();
        client.updateCustomer(UUID.randomUUID(),dto);
    }

    @Test
    void deleteCustomerById() {
        client.deleteCustomerById(UUID.randomUUID());
    }
}