package com.api.service.impl;

import com.api.domain.ActorsEntity;
import com.api.domain.CountriesEntity;
import com.api.domain.CountryInfo;
import com.api.domain.FilmactorsEntity;
import com.api.exception.DataBaseException;
import com.api.exception.EntityNotFoundException;
import com.api.repository.CountryInfoRepository;
import com.api.repository.CountryRepository;
import com.api.repository.FilmActorRepository;
import com.api.service.FilmActorProcedureService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmActorProcedureServiceImpl implements FilmActorProcedureService {

    @Autowired
    FilmActorRepository filmActorRepository;

    @Override
    public FilmactorsEntity findById(Integer id) {
        return filmActorRepository.findById(id) .orElseThrow(() ->new EntityNotFoundException(id, "FilmActors"));
    }
    @Override
    public FilmactorsEntity addFilmActor(Integer filmId, Integer actorId) {

        try {
            System.out.println("----TRY add FilmActor BY PROCEDURE -------");
            var newEntity = filmActorRepository.addFilmActor(filmId, actorId);
            filmActorRepository.flush();
            return newEntity;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }


    // --------------------------------------------------
    @Override
    public List<FilmactorsEntity> findAll() {
        return null;
    }

    @Override
    public FilmactorsEntity create(FilmactorsEntity entity) {
        return null;
    }

    @Override
    public void update(Integer integer, FilmactorsEntity entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
