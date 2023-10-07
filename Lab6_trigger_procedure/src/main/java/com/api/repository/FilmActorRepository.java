package com.api.repository;

import com.api.domain.CountriesEntity;
import com.api.domain.FilmactorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmactorsEntity, Integer>, FilmActorsCustomRepository {
}
