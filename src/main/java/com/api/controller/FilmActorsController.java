package com.api.controller;

import com.api.domain.Filmactor;

import java.util.List;

public interface FilmActorsController extends GeneralController<Filmactor, Integer>{
    List<Filmactor> findByFilmId(Integer film_id);

    List<Filmactor> findByActorId(Integer actor_id);
}
