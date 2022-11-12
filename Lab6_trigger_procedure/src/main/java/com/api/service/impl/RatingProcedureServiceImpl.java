package com.api.service.impl;


import com.api.domain.RaitingsEntity;
import com.api.exception.DataBaseException;
import com.api.repository.CountryRepository;
import com.api.repository.RaitingRepository;
import com.api.service.RatingProcedureService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingProcedureServiceImpl implements RatingProcedureService {

    @Autowired
    RaitingRepository raitingRepository;
    @Override
    public Float getAvgRating() {
        try {
            System.out.println("----TRY get avg rating FUNCTION  BY PROCEDURE -------");
            var result = raitingRepository.getAvgRating();
            raitingRepository.flush();
            return result;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }
// ---------------------------------------------------------------------------

    @Override
    public List<RaitingsEntity> findAll() {
        return null;
    }

    @Override
    public RaitingsEntity findById(Integer integer) {
        return null;
    }
    @Override
    public RaitingsEntity create(RaitingsEntity entity) {
        return null;
    }

    @Override
    public void update(Integer integer, RaitingsEntity entity) {

    }

    @Override
    public void delete(Integer integer) {

    }

}
