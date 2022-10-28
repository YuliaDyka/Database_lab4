package com.api.controller;

import com.api.domain.Film;

import java.util.Optional;

public interface FilmsController extends GeneralController<Film, Integer>{
    Optional<Film> findByName(String name);
}
