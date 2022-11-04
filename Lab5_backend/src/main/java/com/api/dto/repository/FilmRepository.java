package com.api.dto.repository;

import com.api.domain.FilmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmsEntity, Integer> {
}
