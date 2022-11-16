package com.api.repository;

import com.api.domain.CountryInfo;

public interface CountryInfoRepositoryCustom {
    CountryInfo addCountryInfoByProcedure(Integer countryId, String info);
}
