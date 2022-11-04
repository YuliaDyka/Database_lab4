package com.api.service;

import com.api.domain.CashCollectionEntity;

import java.util.List;

public interface CashCollectionService extends GeneralService<CashCollectionEntity, Integer>{
    List<CashCollectionEntity> FindByFilmId (Integer film_id);
}
