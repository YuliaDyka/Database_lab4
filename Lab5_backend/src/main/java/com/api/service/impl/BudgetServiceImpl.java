package com.api.service.impl;

import com.api.domain.BudgetEntity;
import com.api.dto.repository.FilmRepository;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.BudgetRepository;
import com.api.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    FilmRepository filmRepository;

    public List<BudgetEntity> FindByFilmId(Integer film_id) {
        return budgetRepository.findByFilmId(film_id);
    }

    public List<BudgetEntity> findAll() {
        return budgetRepository.findAll();
    }

    public BudgetEntity findById(Integer id) {
        return budgetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Budgets"));
    }

    @Transactional
    public BudgetEntity create(BudgetEntity entity) {
        filmRepository.findById(entity.getFilmId()).orElseThrow(() -> new EntityNotFoundException(entity.getFilmId(), "Film"));
        return budgetRepository.save(entity);
    }

    @Transactional
    public void update(Integer id, BudgetEntity entity) {
        BudgetEntity budget = budgetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Budgets"));

        budget.setFilmId(entity.getFilmId());
        budget.setPrice(entity.getPrice());
        budgetRepository.save(budget);
    }

    @Transactional
    public void delete(Integer id) {
        BudgetEntity budget = budgetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Budgets"));
        budgetRepository.delete(budget);
    }
}
