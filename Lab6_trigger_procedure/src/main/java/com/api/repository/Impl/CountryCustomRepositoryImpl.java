package com.api.repository.Impl;

import com.api.domain.CountriesEntity;
import com.api.domain.CountryInfo;
import com.api.repository.CountryCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class CountryCustomRepositoryImpl implements CountryCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CountriesEntity> addValuesToCountry(Integer startNum, Integer count) {
        StoredProcedureQuery newEntity =
                em.createNamedStoredProcedureQuery("addValuesToCountry")
                        .setParameter("in_start_num", startNum)
                        .setParameter("in_count", count);

        return newEntity.getResultList();
    }
}
