package com.api.dao;

import com.api.domain.Cash_collection;

import java.util.List;
import java.util.Optional;

public interface Cash_collectionDao extends GeneralDao<Cash_collection, Integer> {
    List<Cash_collection> findByFilmId(Integer film_id);
}