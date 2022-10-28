package com.api.dao;

import com.api.domain.Raiting;

import java.util.List;

public interface RaitingsDao extends GeneralDao<Raiting, Integer> {
    List<Raiting> findByFilmId(Integer film_id);
}