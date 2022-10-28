package com.api.controller;

import com.api.domain.New;

import java.util.List;

public interface NewController extends GeneralController<New, Integer> {
    List<New> FindByFilmId(Integer film_id);
}
