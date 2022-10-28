package com.api.controller;

import com.api.domain.Raiting;

import java.util.List;

public interface RaitingsController extends  GeneralController<Raiting, Integer> {
    List<Raiting> FindByFilmId(Integer film_id);
}
