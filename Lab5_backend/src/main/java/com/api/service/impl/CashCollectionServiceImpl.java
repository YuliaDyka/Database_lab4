package com.api.service.impl;

import com.api.domain.CashCollectionEntity;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.CashCollectionRepository;
import com.api.service.CashCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CashCollectionServiceImpl implements CashCollectionService {

    @Autowired
    CashCollectionRepository cashCollectionRepository;

    public List<CashCollectionEntity> FindByFilmId(Integer film_id) {
        return cashCollectionRepository.findByFilmId(film_id);
    }

    public List<CashCollectionEntity> findAll() {
        return cashCollectionRepository.findAll();
    }

    public CashCollectionEntity findById(Integer id) {
        return cashCollectionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Cash"));
    }

    @Transactional
    public CashCollectionEntity create(CashCollectionEntity entity) {
        return cashCollectionRepository.save(entity);
    }

    @Transactional
    public void update(Integer id, CashCollectionEntity entity) {
        CashCollectionEntity cashCollectionEntity = cashCollectionRepository
                .findById(id).orElseThrow(() ->  new EntityNotFoundException(id, "Cash"));

        cashCollectionEntity.setFilmId(entity.getFilmId());
        cashCollectionEntity.setPrice(entity.getPrice());
        cashCollectionRepository.save(cashCollectionEntity);
    }

    @Transactional
    public void delete(Integer id) {
        CashCollectionEntity cashCollectionEntity = cashCollectionRepository
                .findById(id).orElseThrow(() ->  new EntityNotFoundException(id, "Cash"));

        cashCollectionRepository.delete(cashCollectionEntity);
    }
}
