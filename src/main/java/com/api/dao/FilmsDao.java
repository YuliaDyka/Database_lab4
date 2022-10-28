package com.api.dao;

import com.api.domain.Film;

import java.util.Optional;

public interface FilmsDao extends GeneralDao<Film, Integer> {
    Optional<Film> findByFilmName(String name);
}
