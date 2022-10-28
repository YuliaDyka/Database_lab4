package com.api.controller.impl;

import com.api.controller.FilmActorsController;
import com.api.domain.Filmactor;
import com.api.domain.service.FilmActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmActorsControllerImpl implements FilmActorsController {

    @Autowired
    private FilmActorsService filmActorsService;

    @Override
    public List<Filmactor> findByFilmId(Integer film_id) {
        return filmActorsService.findByFilmId(film_id);
    }

    @Override
    public List<Filmactor> findByActorId(Integer actor_id) {
        return filmActorsService.findByActorId(actor_id);
    }

    @Override
    public List<Filmactor> findAll() {
        return filmActorsService.findAll();
    }

    @Override
    public Optional<Filmactor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Filmactor entity) {
        return filmActorsService.create(entity);
    }

    @Override
    public int update(Integer id, Filmactor entity) {
        return filmActorsService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return filmActorsService.delete(id);
    }
}
