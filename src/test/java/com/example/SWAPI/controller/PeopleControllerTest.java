package com.example.SWAPI.controller;

import com.example.SWAPI.service.SwApiService;
import feign.FeignException;
import feign.Request;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext wac;


    @Before("")
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PeopleController()).build();
    }

    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {
    }


    @Autowired
    PeopleController peopleController;

    @MockBean
    SwApiService swApiService;

}
