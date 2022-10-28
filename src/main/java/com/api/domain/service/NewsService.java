package com.api.domain.service;

import com.api.domain.New;

import java.util.List;

public interface NewsService extends GeneralService<New, Integer> {
    List<New> FindByFilmId (Integer film_id);
}
