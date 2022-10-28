package com.api.dao;

import com.api.domain.Actor;

import java.util.Optional;

public interface ActorsDao extends GeneralDao<Actor, Integer> {
    Optional<Actor> findByActorName(String name);
}