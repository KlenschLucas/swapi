package com.example.SWAPI.service;

import com.example.SWAPI.persistence.dto.SwApiPeopleResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SwApiServiceTest {

    @Autowired
    SwApiService swApiService;

    /**
     * Test that the api returns a response and some results in the response
     */
    @Test
    void testGetAll() {
        SwApiPeopleResponse response = swApiService.getAll(1, "");
        Assert.notNull(response, "Response is null");
        Assert.notEmpty(response.getResults(), "Response has elements");
    }


    /**
     * Test that when we search for a name the api returns that record in the response
     */
    @Test
    void testSearch() {
        SwApiPeopleResponse response = swApiService.getAll(1, "Luke Skywalker");
        Assert.notNull(response, "Response is null");
        Assert.notEmpty(response.getResults(), "Response has elements");
        Assert.state(response.getResults().get(0).getName().equalsIgnoreCase("Luke Skywalker"), "Results contain searched name");
    }
}
