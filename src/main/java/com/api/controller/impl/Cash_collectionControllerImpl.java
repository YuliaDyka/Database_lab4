package com.api.controller.impl;

import com.api.controller.Cash_collectionController;
import com.api.domain.Cash_collection;
import com.api.domain.service.Cash_collectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Cash_collectionControllerImpl implements Cash_collectionController {

    @Autowired
    private Cash_collectionService cash_collectionService;

    @Override
    public List<Cash_collection> FindByFilmId(Integer film_id) {
        return cash_collectionService.FindByFilmId(film_id);
    }

    @Override
    public List<Cash_collection> findAll() {
        return cash_collectionService.findAll();
    }

    @Override
    public Optional<Cash_collection> findById(Integer id) {
        return cash_collectionService.findById(id);
    }

    @Override
    public int create(Cash_collection cash_collection) {
        return cash_collectionService.create(cash_collection);
    }

    @Override
    public int update(Integer id, Cash_collection cash_collection) {
        return cash_collectionService.update(id, cash_collection);
    }

    @Override
    public int delete(Integer id) {
        return cash_collectionService.delete(id);
    }
}
