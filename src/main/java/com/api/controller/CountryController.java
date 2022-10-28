package com.api.controller;

import com.api.domain.Country;

import java.util.Optional;

public interface CountryController extends  GeneralController<Country, Integer>{
    Optional<Country> findByName(String name);
}
