package com.api.service;


import com.api.domain.CountriesEntity;

import java.util.List;

public interface CountryProcedureService extends GeneralService<CountriesEntity, Integer>{
    List<CountriesEntity> addValuesToCountry(Integer startNum, Integer count);
}
