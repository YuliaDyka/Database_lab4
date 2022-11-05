package com.api.repository.Impl;

import com.api.domain.CountryInfo;
import com.api.repository.CountryInfoRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class CountryInfoRepositoryCustomImpl implements CountryInfoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public CountryInfo addCountryInfoByProcedure(Integer countryId, String info) {

        StoredProcedureQuery newEntity =
                em.createNamedStoredProcedureQuery("addCountryInfoByProcedure")
                        .setParameter("in_country_id", countryId).setParameter("in_info", info);

        return (CountryInfo)newEntity.getSingleResult();
    }
}
