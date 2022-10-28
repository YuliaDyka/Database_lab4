package com.api.dao;

import com.api.domain.New;
import com.api.domain.Reviewer;

import java.util.List;
import java.util.Optional;

public interface NewsDao extends GeneralDao<New, Integer> {
    List<New> findByFilmId(Integer film_id);
}