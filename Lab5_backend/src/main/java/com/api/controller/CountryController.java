package com.api.controller;

import com.api.domain.CountriesEntity;
import com.api.dto.CountryDto;
import com.api.dto.assembler.CountryAssembler;
import com.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryAssembler countryAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable Integer id) {
        CountriesEntity country = countryService.findById(id);
        CountryDto CountryDto = countryAssembler.toModel(country);
        return new ResponseEntity<>(CountryDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CountryDto>> getAll() {
        List<CountriesEntity> countries = countryService.findAll();
        CollectionModel<CountryDto> countryDtos = countryAssembler.toCollectionModel(countries);
        return new ResponseEntity<>(countryDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CountryDto> add(@RequestBody CountriesEntity entity) {
        CountriesEntity countries = countryService.create(entity);
        CountryDto countryDto = countryAssembler.toModel(countries);
        return new ResponseEntity<>(countryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBudget(@RequestBody CountriesEntity updateEntity, @PathVariable Integer id) {
        countryService.update(id, updateEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable Integer id) {
        countryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
