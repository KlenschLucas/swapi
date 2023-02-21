package com.example.SWAPI.mapper;

import com.example.SWAPI.persistence.dto.GetAllPeopleResponse;
import com.example.SWAPI.persistence.dto.SwApiPeopleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetAllPeopleResponseMapper {
    GetAllPeopleResponseMapper INSTANCE = Mappers.getMapper(GetAllPeopleResponseMapper.class);

    GetAllPeopleResponse swApiPeopleResponseToGetAllPeopleResponse(SwApiPeopleResponse swApiPeopleResponse);
}
