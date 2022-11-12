package com.api.service.impl;

import com.api.domain.CountriesEntity;
import com.api.exception.DataBaseException;
import com.api.repository.CountryRepository;
import com.api.service.CountryProcedureService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryProcedureServiceImpl implements CountryProcedureService {

    @Autowired
    CountryRepository countryRepository;
    @Override
    public List<CountriesEntity> addValuesToCountry(Integer startNum, Integer count) {
        try {
            System.out.println("----TRY add values to COUNTRY BY PROCEDURE -------");
            var newEntity = countryRepository.addValuesToCountry(startNum, count);
            countryRepository.flush();
            return newEntity;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }


    // --------------------------------------------------------------------
    @Override
    public List<CountriesEntity> findAll() {
        return null;
    }

    @Override
    public CountriesEntity findById(Integer integer) {
        return null;
    }

    @Override
    public CountriesEntity create(CountriesEntity entity) {
        return null;
    }

    @Override
    public void update(Integer integer, CountriesEntity entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
