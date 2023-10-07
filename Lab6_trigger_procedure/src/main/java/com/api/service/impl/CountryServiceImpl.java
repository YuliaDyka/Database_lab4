package com.api.service.impl;

import com.api.domain.CountriesEntity;
import com.api.exception.DataBaseException;
import com.api.exception.EntityNotFoundException;
import com.api.repository.CountryRepository;
import com.api.service.CountryService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<CountriesEntity> findAll() {
        return countryRepository.findAll();
    }

    public CountriesEntity findById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException(id, "Countries"));
    }

    @Transactional
    public CountriesEntity create(CountriesEntity entity) {
        countryRepository.save(entity);
        return entity;
    }

    @Transactional
    public void update(Integer id, CountriesEntity update) {
        CountriesEntity countries = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Countries"));

        try {
            System.out.println("----TRY Update country BY TRIGGER-------");
            countries.setName(update.getName());
            countryRepository.save(countries);
            countryRepository.flush();
        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
    }

    @Transactional
    public void delete(Integer id) {
        CountriesEntity country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Countries"));
        try {
            System.out.println("----TRY DELETE BY TRIGGER-------");
            countryRepository.delete(country);
            countryRepository.flush();
        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }

        }
    }
}
