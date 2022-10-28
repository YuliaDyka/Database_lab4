package com.api.controller;

import com.api.domain.Cash_collection;

import java.util.List;

public interface Cash_collectionController extends GeneralController<Cash_collection, Integer> {
    List<Cash_collection> FindByFilmId(Integer film_id);
}
