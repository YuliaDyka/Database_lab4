package com.api.dao;

import com.api.domain.Budget;

import java.util.List;

public interface BudgetDao extends GeneralDao<Budget, Integer> {
    List<Budget> findByFilmId(Integer film_id);
}