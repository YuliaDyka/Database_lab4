package com.api.repository;

import com.api.domain.CountriesEntity;

import java.util.List;

public interface CountryCustomRepository {
    List<CountriesEntity> addValuesToCountry(Integer startNum, Integer count);
}
