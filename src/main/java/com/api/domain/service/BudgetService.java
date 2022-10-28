package com.api.domain.service;

import com.api.domain.Budget;

import java.util.List;

public interface BudgetService extends GeneralService<Budget, Integer> {
    List<Budget> FindByFilmId (Integer film_id);
}
