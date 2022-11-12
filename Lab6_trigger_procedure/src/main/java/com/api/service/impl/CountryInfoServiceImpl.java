package com.api.service.impl;

import com.api.domain.CountryInfo;
import com.api.domain.FilmsEntity;
import com.api.exception.DataBaseException;
import com.api.exception.EntityNotFoundException;
import com.api.repository.CountryInfoRepository;
import com.api.service.CountryInfoService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryInfoServiceImpl implements CountryInfoService {

    @Autowired
    CountryInfoRepository countryInfoRepository;

    @Override
    public List<CountryInfo> findAll() {
        return countryInfoRepository.findAll();
    }

    @Override
    public CountryInfo findById(Integer id) {
        return countryInfoRepository.findById(id)
                .orElseThrow(() ->new EntityNotFoundException(id, "CountryInfo"));
    }

    @Override
    public CountryInfo create(CountryInfo entity) {
        try {
            System.out.println("----TRY Insert countryInfo using trigger -------");
            countryInfoRepository.save(entity);
            countryInfoRepository.flush();
            return entity;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, CountryInfo update) {
        var countryInfoEntity = countryInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "CountryInfo"));

        try {
            System.out.println("----TRY Update countryInfo using trigger -------");
            //update
            countryInfoEntity.setCountryId(update.getCountryId());
            countryInfoEntity.setInfo(update.getInfo());
            countryInfoRepository.save(countryInfoEntity);

            countryInfoRepository.flush();
        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }

    }

    @Override
    public void delete(Integer id) {
        var countryInfo = countryInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "CountryInfo"));
        countryInfoRepository.delete(countryInfo);

    }
}
