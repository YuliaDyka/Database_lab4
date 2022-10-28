package com.api.domain.service;

import com.api.domain.Cash_collection;

import java.util.List;

public interface Cash_collectionService extends GeneralService<Cash_collection, Integer>{
    List<Cash_collection> FindByFilmId (Integer film_id);
}
