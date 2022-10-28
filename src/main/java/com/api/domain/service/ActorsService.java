package com.api.domain.service;

import com.api.domain.Actor;

import java.util.Optional;

public interface ActorsService extends GeneralService<Actor, Integer> {
    Optional<Actor> findByName(String name);
}
