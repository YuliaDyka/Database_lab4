package com.api.service;

import com.api.domain.ActorsEntity;
import com.api.domain.CashCollectionEntity;
import com.api.domain.CountryInfo;

public interface CountryInfoProcedureService extends GeneralService<CountryInfo, Integer> {
    CountryInfo addCountryInfoByProcedure(Integer countryId, String info);
}
