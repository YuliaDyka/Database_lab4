package com.api.controller.impl;

import com.api.controller.ActorsController;
import com.api.controller.FilmActorsController;
import com.api.domain.Actor;
import com.api.domain.service.ActorsService;
import com.api.domain.service.FilmActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsControllerImpl implements ActorsController {
    @Autowired
    private ActorsService actorsService;
    @Autowired
    private FilmActorsService filmActorsService;
    @Override
    public Optional<Actor> findByName(String name) {
        return actorsService.findByName(name);
    }

    @Override
    public List<Actor> findAll() {
        return actorsService.findAll();
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        return actorsService.findById(id);
    }

    @Override
    public int create(Actor entity) {
        return actorsService.create(entity);
    }

    @Override
    public int update(Integer id, Actor entity) {
        return actorsService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return actorsService.delete(id);
    }
}
