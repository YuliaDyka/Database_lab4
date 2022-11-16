package com.api.service;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;

import java.util.List;

public interface ActorService extends  GeneralService<ActorsEntity, Integer>{

    ActorsEntity create(ActorsEntity entity, Integer filmId);
    void update(Integer actor_Id, ActorsEntity actor, Integer film_Id);
    List<FilmsEntity> FindFilmsByActorId (Integer id);

    public ActorsEntity addFilmForActor(Integer filmId, Integer actorId);

    public ActorsEntity removeFilmForActor(Integer filmId, Integer actorId);

    public List<ActorsEntity> getActorsByFilmId(Integer filmId);
}
