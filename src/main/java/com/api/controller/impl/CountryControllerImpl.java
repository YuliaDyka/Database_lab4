package com.api.controller.impl;


import com.api.controller.CountryController;
import com.api.domain.Country;
import com.api.domain.service.CountryService;
import com.api.domain.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryControllerImpl implements CountryController {

    @Autowired
    private CountryService countryService;

    @Override
    public Optional<Country> findByName(String name) {
        return countryService.findByName(name);
    }

    @Override
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countryService.findById(id);
    }

    @Override
    public int create(Country entity) {
        return countryService.create(entity);
    }

    @Override
    public int update(Integer id, Country entity) {
        return countryService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return countryService.delete(id);
    }
}
