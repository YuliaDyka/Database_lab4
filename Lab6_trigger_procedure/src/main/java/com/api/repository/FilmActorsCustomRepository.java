package com.api.repository;

import com.api.domain.CountryInfo;
import com.api.domain.FilmactorsEntity;

public interface FilmActorsCustomRepository {
    FilmactorsEntity addFilmActor(Integer filmId, Integer actorId);
}
