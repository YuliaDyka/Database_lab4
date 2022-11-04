package com.api.service.impl;

import com.api.domain.NominationsEntity;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.NominationRepository;
import com.api.service.NominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NominationServiceImpl implements NominationService {
    @Autowired
    NominationRepository nominationRepository;

    public List<NominationsEntity> findAll() {
        return nominationRepository.findAll();
    }

    public NominationsEntity findById(Integer id) {
        return nominationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Nominations"));

    }

    public List<NominationsEntity> FindByFilmId(Integer film_id) {
        return nominationRepository.findByFilmId(film_id);
    }

    @Transactional
    public NominationsEntity create(NominationsEntity entity) {
        nominationRepository.save(entity);
        return entity;
    }

    @Transactional
    public void update(Integer id, NominationsEntity entity) {
        NominationsEntity nominations = nominationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Nominations"));
        //update
        nominations.setNomination(entity.getNomination());
        nominations.setFilmId(entity.getFilmId());
        nominationRepository.save(nominations);
    }

    @Transactional
    public void delete(Integer id) {
        NominationsEntity nominations = nominationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Nominations"));
        nominationRepository.delete(nominations);
    }
}
