package com.api.dao;

import com.api.domain.Nomination;

import java.util.List;

public interface NominationsDao extends GeneralDao<Nomination, Integer> {
    List<Nomination> findByFilmId(Integer film_id);
}