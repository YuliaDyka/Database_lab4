package com.api.service.impl;

import com.api.domain.CountriesEntity;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.CountryRepository;
import com.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;

//    public List<CountriesEntity> FindByName(String name) {
//        return countryRepository.FindByName(name);
//    }

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
        //update
        countries.setName(update.getName());
        countryRepository.save(countries);
    }

    @Transactional
    public void delete(Integer id) {
        CountriesEntity countrie = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Countries"));
        countryRepository.delete(countrie);
    }
}
