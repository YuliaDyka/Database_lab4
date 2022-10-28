package com.api.controller;

import com.api.domain.Budget;

import java.util.List;

public interface BudgetController extends GeneralController<Budget, Integer> {
    List<Budget> FindByFilmId(Integer film_id);
}
