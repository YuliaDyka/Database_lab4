package com.api.controller;

import com.api.domain.CountriesEntity;
import com.api.domain.CountryInfo;
import com.api.dto.CountryDto;
import com.api.dto.CountryInfoDto;
import com.api.dto.assembler.CountryAssembler;
import com.api.dto.assembler.CountryInfoAssembler;
import com.api.service.CountryInfoProcedureService;
import com.api.service.CountryProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/country_procedure")
public class CountryProcedureController {

    @Autowired
    CountryProcedureService countryProcedureService;
    @Autowired
    private CountryAssembler countryAssembler;

    @PostMapping(value = "")
    public ResponseEntity<CollectionModel<CountryDto>> addCountriesByProcedure() {

        Integer startNum = 1;
        Integer count = 10;
        var newEntities = countryProcedureService
                .addValuesToCountry(startNum, count);

       var countriesDto = countryAssembler.toCollectionModel(newEntities);

        return new ResponseEntity<>(countriesDto, HttpStatus.CREATED);
    }
}
