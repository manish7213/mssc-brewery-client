package com.sfg.msscbreweryclient.client;

import com.sfg.msscbreweryclient.model.BeerDto;
import com.sfg.msscbreweryclient.model.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    @Value("${com.sfg.apiHost}")
    public String apiHost;

    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(),CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId.toString(), customerDto);
    }

    public void deleteCustomerById(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId.toString());
    }
}
