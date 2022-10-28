package com.api.dao;

import com.api.domain.Country;

import java.util.Optional;

public interface CountriesDao extends GeneralDao<Country, Integer> {
    Optional<Country> findByCountryName(String name);
}