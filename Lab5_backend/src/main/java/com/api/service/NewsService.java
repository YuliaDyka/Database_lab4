package com.api.service;

import com.api.domain.NewsEntity;

import java.util.List;

public interface NewsService extends GeneralService<NewsEntity, Integer> {
    List<NewsEntity> FindByFilmId (Integer film_id);
}
