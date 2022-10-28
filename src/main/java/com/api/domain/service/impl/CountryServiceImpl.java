package com.api.domain.service.impl;

import com.api.dao.CountriesDao;
import com.api.domain.Country;
import com.api.domain.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountriesDao countriesDao;

    @Override
    public Optional<Country> findByName(String name) {
        return countriesDao.findByCountryName(name);
    }

    @Override
    public List<Country> findAll() {
        return countriesDao.findAll();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countriesDao.findById(id);
    }

    @Override
    public int create(Country entity) {
        return countriesDao.create(entity);
    }

    @Override
    public int update(Integer id, Country entity) {
        return countriesDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return countriesDao.delete(id);
    }
}
