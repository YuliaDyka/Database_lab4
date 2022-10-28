package com.api.domain.service.impl;

import com.api.dao.BudgetDao;
import com.api.domain.Budget;
import com.api.domain.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetDao budgetDao;

    @Override
    public List<Budget> FindByFilmId(Integer film_id) {
        return budgetDao.findByFilmId(film_id);
    }

    @Override
    public List<Budget> findAll() {
        return budgetDao.findAll();
    }

    @Override
    public Optional<Budget> findById(Integer id) {
        return budgetDao.findById(id);
    }

    @Override
    public int create(Budget budget) {
        return budgetDao.create(budget);
    }

    @Override
    public int update(Integer id, Budget budget) {
        return budgetDao.update(id, budget);
    }

    @Override
    public int delete(Integer id) {
        return budgetDao.delete(id);
    }
}
