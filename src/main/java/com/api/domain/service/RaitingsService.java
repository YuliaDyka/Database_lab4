package com.api.domain.service;

import com.api.controller.GeneralController;
import com.api.domain.Raiting;

import java.util.List;

public interface RaitingsService extends GeneralController<Raiting, Integer> {
    List<Raiting> FindByFilmId (Integer film_id);
}
