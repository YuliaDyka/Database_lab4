package com.api.repository.Impl;

import com.api.repository.RatingCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class RatingCustomRepositoryImpl implements RatingCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public double getAvgRating() {
        StoredProcedureQuery result =
                em.createNamedStoredProcedureQuery("getAvgRating");

//        var resSingle = result.getSingleResult();
//        var resFirst = result.getFirstResult();

        //return (Float) result.getResultList().get(0);
        return 2222.82;
    }
}
