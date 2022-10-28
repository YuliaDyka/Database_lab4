package com.api.dao;

import com.api.domain.Filmactor;

import java.util.List;

public interface FilmActorsDao extends GeneralDao<Filmactor, Integer> {
    List<Filmactor> findByFilmId(Integer film_id);

    List<Filmactor> findByActorId(Integer actor_id);

    //String addFilmToActors(Integer film_id, Integer actor_id);
}