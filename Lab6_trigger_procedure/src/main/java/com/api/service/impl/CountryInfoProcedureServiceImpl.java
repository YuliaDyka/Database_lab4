package com.api.service.impl;

import com.api.domain.CountriesEntity;
import com.api.domain.CountryInfo;
import com.api.exception.DataBaseException;
import com.api.exception.EntityNotFoundException;
import com.api.repository.CountryInfoRepository;
import com.api.repository.CountryRepository;
import com.api.service.CountryInfoProcedureService;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryInfoProcedureServiceImpl implements CountryInfoProcedureService {
    @Autowired
    CountryInfoRepository countryInfoRepository;

    @Autowired
    CountryRepository countryRepository;

    @Override
    public CountryInfo addCountryInfoByProcedure(Integer countryId, String info) {

        try {
            System.out.println("----TRY Update country info BY PROCEDURE -------");
            var newEntity = countryInfoRepository.addCountryInfoByProcedure(countryId, info);
            countryInfoRepository.flush();
            return newEntity;

        } catch (JpaSystemException ex) {
            if (ex.getCause() instanceof GenericJDBCException) {
                GenericJDBCException gex = (GenericJDBCException)ex.getCause();
                throw new DataBaseException(gex.getSQLException().getMessage());
            }
        }
        return null;
    }

    @Override
    public List<CountryInfo> findAll() {
        return countryInfoRepository.findAll();
    }

    @Override
    public CountryInfo findById(Integer id) {
        return countryInfoRepository.findById(id).orElseThrow(() ->new EntityNotFoundException(id, "CountryInfos"));
    }


    // -----------------------------------------------
    @Override
    public CountryInfo create(CountryInfo entity) {
        return null;
    }

    @Override
    public void update(Integer integer, CountryInfo entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
