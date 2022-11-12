package com.api.repository.Impl;

import com.api.domain.CountryInfo;
import com.api.repository.RatingCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class RatingCustomRepositoryImpl implements RatingCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Float getAvgRating() {
        StoredProcedureQuery result =
                em.createNamedStoredProcedureQuery("getAvgRating");

        return (Float) result.getResultList().get(0);
    }
}
