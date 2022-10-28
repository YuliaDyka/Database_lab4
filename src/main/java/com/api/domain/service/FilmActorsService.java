package com.api.domain.service;

import com.api.domain.Filmactor;

import java.util.List;

public interface FilmActorsService extends GeneralService<Filmactor, Integer> {
    List<Filmactor> findByFilmId(Integer film_id);

    List<Filmactor> findByActorId(Integer actor_id);
}
