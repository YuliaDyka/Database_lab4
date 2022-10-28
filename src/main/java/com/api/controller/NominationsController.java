package com.api.controller;

import com.api.domain.Nomination;


import java.util.List;

public interface NominationsController extends GeneralController<Nomination, Integer> {
    List<Nomination> FindByFilmId(Integer film_id);
}
