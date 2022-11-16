package com.api.controller;

import com.api.domain.CountryInfo;
import com.api.dto.CountryInfoDto;
import com.api.dto.assembler.CountryInfoAssembler;
import com.api.service.CountryInfoProcedureService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/country_info_procedure")
public class CountryInfoProcedureController {

    @Autowired
    CountryInfoProcedureService countryInfoProcedureService;
    @Autowired
    private CountryInfoAssembler countryInfoAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryInfoDto> getById(@PathVariable Integer id) {
        CountryInfo countryInfo = countryInfoProcedureService.findById(id);
        CountryInfoDto countryInfoDto = countryInfoAssembler.toModel(countryInfo);

        return new ResponseEntity<>(countryInfoDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CountryInfoDto> addCountryInfoByProcedure(@RequestBody CountryInfo entity) {

        String info = entity.getInfo() != null ? entity.getInfo() : "Default info";

       CountryInfo newEntity = countryInfoProcedureService
                .addCountryInfoByProcedure(entity.getCountryId(), info);

        CountryInfoDto countryInfoDto = countryInfoAssembler.toModel(newEntity);

        return new ResponseEntity<>(countryInfoDto, HttpStatus.CREATED);
    }
}
