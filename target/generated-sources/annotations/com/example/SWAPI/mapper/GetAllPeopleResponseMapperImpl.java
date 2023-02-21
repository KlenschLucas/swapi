package com.example.SWAPI.mapper;

import com.example.SWAPI.persistence.dto.GetAllPeopleResponse;
import com.example.SWAPI.persistence.dto.PersonResponse;
import com.example.SWAPI.persistence.dto.Result;
import com.example.SWAPI.persistence.dto.SwApiPeopleResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-21T03:49:44+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_352 (Private Build)"
)
public class GetAllPeopleResponseMapperImpl implements GetAllPeopleResponseMapper {

    @Override
    public GetAllPeopleResponse swApiPeopleResponseToGetAllPeopleResponse(SwApiPeopleResponse swApiPeopleResponse) {
        if ( swApiPeopleResponse == null ) {
            return null;
        }

        GetAllPeopleResponse getAllPeopleResponse = new GetAllPeopleResponse();

        if ( swApiPeopleResponse.getCount() != null ) {
            getAllPeopleResponse.setCount( swApiPeopleResponse.getCount() );
        }
        getAllPeopleResponse.setNext( swApiPeopleResponse.getNext() );
        getAllPeopleResponse.setPrevious( swApiPeopleResponse.getPrevious() );
        getAllPeopleResponse.setResults( resultListToPersonResponseList( swApiPeopleResponse.getResults() ) );

        return getAllPeopleResponse;
    }

    protected PersonResponse resultToPersonResponse(Result result) {
        if ( result == null ) {
            return null;
        }

        PersonResponse personResponse = new PersonResponse();

        personResponse.setBirthYear( result.getBirthYear() );
        personResponse.setName( result.getName() );
        personResponse.setHeight( result.getHeight() );
        personResponse.setMass( result.getMass() );
        personResponse.setGender( result.getGender() );
        personResponse.setHomeworld( result.getHomeworld() );

        return personResponse;
    }

    protected List<PersonResponse> resultListToPersonResponseList(List<Result> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonResponse> list1 = new ArrayList<PersonResponse>( list.size() );
        for ( Result result : list ) {
            list1.add( resultToPersonResponse( result ) );
        }

        return list1;
    }
}
