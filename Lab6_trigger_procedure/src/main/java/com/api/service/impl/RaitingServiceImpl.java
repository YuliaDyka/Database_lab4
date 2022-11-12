package com.api.service.impl;

import com.api.domain.RaitingsEntity;
import com.api.exception.DataBaseException;
import com.api.exception.EntityNotFoundException;
import com.api.repository.RaitingRepository;
import com.api.service.RaitingService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
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
        try {
            System.out.println("----TRY create row in 'Ratings' BY Trigger - with '00' -------");
            raitingRepository.save(entity);
            raitingRepository.flush();
        return entity;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }

    @Transactional
    public void update(Integer id, RaitingsEntity entity) {
        RaitingsEntity findRating = raitingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Raitings"));

        try {
            System.out.println("----TRY update 'Ratings' BY Trigger -------");
            findRating.setFilmId(entity.getFilmId());
            findRating.setRaiting(entity.getRaiting());
            raitingRepository.save(findRating);
            raitingRepository.flush();

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
    }

    @Transactional
    public void delete(Integer id) {
        RaitingsEntity entity = raitingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Raitings"));

        try {
            System.out.println("----TRY delete row from 'Ratings' BY Trigger -------");
            raitingRepository.delete(entity);
            raitingRepository.flush();

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
    }
}