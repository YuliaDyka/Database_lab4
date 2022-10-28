package com.api.domain.service;

import com.api.domain.Film;

import java.util.Optional;

public interface FilmService extends GeneralService<Film, Integer> {
    Optional<Film> findByName(String name);
}
