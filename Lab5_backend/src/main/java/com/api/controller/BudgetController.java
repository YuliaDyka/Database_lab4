package com.api.controller;

import com.api.domain.BudgetEntity;
import com.api.dto.BudgetDto;
import com.api.dto.assembler.BudgetAssembler;
import com.api.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/budgets")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private BudgetAssembler budgetDtoAssembler;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BudgetDto> getById(@PathVariable Integer id) {
        BudgetEntity budget = budgetService.findById(id);
        BudgetDto budgetDtoDto = budgetDtoAssembler.toModel(budget);
        return new ResponseEntity<>(budgetDtoDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<BudgetDto>> getAllBudgets() {
        List<BudgetEntity> budgets = budgetService.findAll();
        CollectionModel<BudgetDto> budgetDtos = budgetDtoAssembler.toCollectionModel(budgets);
        return new ResponseEntity<>(budgetDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<BudgetDto> addBudget(@RequestBody BudgetEntity budget) {
        BudgetEntity newbudget = budgetService.create(budget);
        BudgetDto cityDto = budgetDtoAssembler.toModel(newbudget);
        return new ResponseEntity<>(cityDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBudget(@RequestBody BudgetEntity updateBudget, @PathVariable Integer id) {
        budgetService.update(id, updateBudget);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable Integer id) {
        budgetService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
