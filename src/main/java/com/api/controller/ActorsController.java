package com.api.controller;

import com.api.domain.Actor;

import java.util.Optional;

public interface ActorsController extends GeneralController<Actor, Integer>{
    Optional<Actor> findByName(String name);
}
