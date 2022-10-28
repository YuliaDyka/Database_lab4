package com.api.controller;

import com.api.domain.Reviewer;

import java.util.List;

public interface ReviewersController extends GeneralController<Reviewer, Integer> {
    List<Reviewer> FindByFilmId(Integer film_id);
}
