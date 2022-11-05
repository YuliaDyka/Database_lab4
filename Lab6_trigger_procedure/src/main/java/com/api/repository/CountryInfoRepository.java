package com.api.repository;

import com.api.domain.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryInfoRepository extends JpaRepository<CountryInfo, Integer>, CountryInfoRepositoryCustom {
  // CountryInfo findByFilmId(Integer filmId);
}
