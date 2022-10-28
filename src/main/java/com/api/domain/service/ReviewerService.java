package com.api.domain.service;

import com.api.domain.Reviewer;

import java.util.List;

public interface ReviewerService extends GeneralService<Reviewer, Integer> {
    List<Reviewer> FindByFilmId (Integer film_id);
}
