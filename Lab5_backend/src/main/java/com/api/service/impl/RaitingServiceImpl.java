package com.api.service.impl;

import com.api.domain.RaitingsEntity;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.RaitingRepository;
import com.api.service.RaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RaitingServiceImpl implements RaitingService {

    @Autowired
    RaitingRepository raitingRepository;

    public List<RaitingsEntity> FindByFilmId(Integer film_id) {
        return raitingRepository.findByFilmId(film_id);
    }

    public List<RaitingsEntity> findAll() {
        return raitingRepository.findAll();
    }

    public RaitingsEntity findById(Integer id) {
        return raitingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Raitings"));
    }

    @Transactional
    public RaitingsEntity create(RaitingsEntity entity) {
        return raitingRepository.save(entity);
    }

    @Transactional
    public void update(Integer id, RaitingsEntity entity) {
        RaitingsEntity findRating = raitingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Raitings"));

        findRating.setFilmId(entity.getFilmId());
        findRating.setRaiting(entity.getRaiting());
        raitingRepository.save(findRating);
    }

    @Transactional
    public void delete(Integer id) {
        RaitingsEntity entity = raitingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Raitings"));
        raitingRepository.delete(entity);
    }
}