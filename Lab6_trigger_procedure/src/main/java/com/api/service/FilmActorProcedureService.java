package com.api.service;

import com.api.domain.CountryInfo;
import com.api.domain.FilmactorsEntity;

public interface FilmActorProcedureService extends GeneralService<FilmactorsEntity, Integer> {
    FilmactorsEntity addFilmActor(Integer filmId, Integer actorId);
}
