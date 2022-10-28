package com.api.controller.impl;

import com.api.controller.BudgetController;
import com.api.domain.Budget;
import com.api.domain.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Override
    public List<Budget> FindByFilmId(Integer film_id) {
        return budgetService.FindByFilmId(film_id);
    }

    @Override
    public List<Budget> findAll() {
        return budgetService.findAll();
    }

    @Override
    public Optional<Budget> findById(Integer id) {
        return budgetService.findById(id);
    }

    @Override
    public int create(Budget budget) {
        return budgetService.create(budget);
    }

    @Override
    public int update(Integer id, Budget budget) {
        return budgetService.update(id, budget);
    }

    @Override
    public int delete(Integer id) {
        return budgetService.delete(id);
    }
}
