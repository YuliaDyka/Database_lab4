package com.api.dto.repository;

import com.api.domain.CountriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountriesEntity, Integer> {
}
