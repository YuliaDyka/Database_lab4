package com.api.service;

import com.api.domain.NominationsEntity;

import java.util.List;

public interface NominationService extends GeneralService<NominationsEntity, Integer> {
    List<NominationsEntity> FindByFilmId (Integer film_id);
}
