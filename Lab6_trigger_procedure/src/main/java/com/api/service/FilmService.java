package com.api.service;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;

import java.util.List;

public interface FilmService extends GeneralService<FilmsEntity, Integer> {

    FilmsEntity create(FilmsEntity entity, Integer actorId);
    public List<ActorsEntity> FindActorByFilmId(Integer id);

    public FilmsEntity addActorForFilm(Integer filmId, Integer actorId);

    public FilmsEntity removeActorForFilm(Integer filmId, Integer actorId);

    public List<FilmsEntity> getFilmsByActorId(Integer actorId);

}
