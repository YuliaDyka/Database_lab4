package com.api.dao;

import com.api.domain.Reviewer;

import java.util.List;

public interface ReviewersDao extends GeneralDao<Reviewer, Integer> {
    List<Reviewer> findByFilmId(Integer film_id);
}