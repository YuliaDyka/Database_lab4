package com.api.service;

import com.api.domain.BudgetEntity;

import java.util.List;

public interface BudgetService extends GeneralService<BudgetEntity, Integer> {
    List<BudgetEntity> FindByFilmId (Integer film_id);
}
