package com.api.repository.Impl;

import com.api.domain.CountryInfo;
import com.api.domain.FilmactorsEntity;
import com.api.repository.FilmActorsCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class FilmActorsCustomRepositoryImpl implements FilmActorsCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public FilmactorsEntity addFilmActor(Integer filmId, Integer actorId) {
        StoredProcedureQuery newEntity =
                em.createNamedStoredProcedureQuery("addFilmActor")
                        .setParameter("in_film_id", filmId)
                        .setParameter("in_actor_id", actorId);

        return (FilmactorsEntity)newEntity.getResultList().get(0);
    }
}
