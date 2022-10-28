package com.api.controller.impl;

import com.api.controller.FilmsController;
import com.api.domain.Film;
import com.api.domain.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsControllerImpl implements FilmsController {

    @Autowired
    private FilmService filmService;

    @Override
    public Optional<Film> findByName(String name) {
        return filmService.findByName(name);
    }

    @Override
    public List<Film> findAll() {
        return filmService.findAll();
    }

    @Override
    public Optional<Film> findById(Integer id) {
        return filmService.findById(id);
    }

    @Override
    public int create(Film film) {
        return filmService.create(film);
    }

    @Override
    public int update(Integer id, Film film) {
        return filmService.update(id, film);
    }

    @Override
    public int delete(Integer id) {
        return filmService.delete(id);
    }
}
