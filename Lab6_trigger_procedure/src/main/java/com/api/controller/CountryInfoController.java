package com.api.controller;


import com.api.domain.CountriesEntity;
import com.api.domain.CountryInfo;
import com.api.dto.CountryDto;
import com.api.dto.CountryInfoDto;
import com.api.dto.assembler.CountryInfoAssembler;
import com.api.service.CountryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/country_info")
public class CountryInfoController {
    @Autowired
    private CountryInfoService countryInfoService;

    @Autowired
    private CountryInfoAssembler countryInfoAssembler;
    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryInfoDto> getById(@PathVariable Integer id) {
        CountryInfo countryInfo = countryInfoService.findById(id);
        CountryInfoDto countryInfoDto = countryInfoAssembler.toModel(countryInfo);
        return new ResponseEntity<>(countryInfoDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CountryInfoDto>> getAll() {
        List<CountryInfo> countryInfos = countryInfoService.findAll();
        CollectionModel<CountryInfoDto> countryInfoDtos = countryInfoAssembler.toCollectionModel(countryInfos);
        return new ResponseEntity<>(countryInfoDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CountryInfoDto> add(@RequestBody CountryInfo entity) {
        CountryInfo countryInfo = countryInfoService.create(entity);
        CountryInfoDto countryInfoDto = countryInfoAssembler.toModel(countryInfo);
        return new ResponseEntity<>(countryInfoDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody CountryInfo updateEntity, @PathVariable Integer id) {
        countryInfoService.update(id, updateEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        countryInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
