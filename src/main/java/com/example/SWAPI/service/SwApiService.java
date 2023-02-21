package com.example.SWAPI.service;

import com.example.SWAPI.persistence.dto.SwApiPeopleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SWAPI", url = "https://swapi.dev/api/people")
public interface SwApiService {

    @GetMapping("")
    public SwApiPeopleResponse getAll(@RequestParam("page") int page, @RequestParam(value = "search", required = false) String search);
}
