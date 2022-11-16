package com.api.service;

import com.api.domain.ReviewersEntity;

import java.util.List;

public interface ReviewersService extends GeneralService<ReviewersEntity, Integer> {
    List<ReviewersEntity> FindByFilmId (Integer film_id);
}
