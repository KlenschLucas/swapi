package com.example.SWAPI.controller;

import com.example.SWAPI.mapper.GetAllPeopleResponseMapper;
import com.example.SWAPI.mapper.GetAllPeopleResponseMapperImpl;
import com.example.SWAPI.persistence.dto.GetAllPeopleResponse;
import com.example.SWAPI.persistence.dto.SwApiPeopleResponse;
import com.example.SWAPI.service.SwApiService;
import feign.FeignException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    SwApiService swApiService;

//    @Autowired
//    private Mapper mapper;

    @GetMapping("")
    @ApiResponse(responseCode = "200", description = "OK Result")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public GetAllPeopleResponse getAllPeople(@RequestParam(value = "page", defaultValue = "1", required = false) int page, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        SwApiPeopleResponse res = swApiService.getAll(page, search);

        GetAllPeopleResponse response = GetAllPeopleResponseMapper.INSTANCE.swApiPeopleResponseToGetAllPeopleResponse(res);
        return response;
    }

    /**
     * If we encounter any problems with the Feign client, send back an internal server error
     *
     * @param e FeignException
     * @return
     */
    @ExceptionHandler({FeignException.class})
    public ResponseEntity<String> handleFeignException(FeignException e) {
        // TODO: log out error
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
