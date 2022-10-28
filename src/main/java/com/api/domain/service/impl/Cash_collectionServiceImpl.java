package com.api.domain.service.impl;

import com.api.dao.Cash_collectionDao;
import com.api.domain.Cash_collection;
import com.api.domain.service.Cash_collectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Cash_collectionServiceImpl implements Cash_collectionService {

    @Autowired
    private Cash_collectionDao cash_collectionDao;

    @Override
    public List<Cash_collection> FindByFilmId(Integer film_id) {
        return cash_collectionDao.findByFilmId(film_id);
    }

    @Override
    public List<Cash_collection> findAll() {
        return cash_collectionDao.findAll();
    }

    @Override
    public Optional<Cash_collection> findById(Integer id) {
        return cash_collectionDao.findById(id);
    }

    @Override
    public int create(Cash_collection cash_collection) {
        return cash_collectionDao.create(cash_collection);
    }

    @Override
    public int update(Integer id, Cash_collection cash_collection) {
        return cash_collectionDao.update(id, cash_collection);
    }

    @Override
    public int delete(Integer id) {
        return cash_collectionDao.delete(id);
    }
}
