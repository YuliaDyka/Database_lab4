package com.api.domain.service;

import com.api.domain.Country;
import com.api.domain.Film;

import java.util.Optional;

public interface CountryService
        extends GeneralService<Country, Integer> {
    Optional<Country> findByName(String name);
}

