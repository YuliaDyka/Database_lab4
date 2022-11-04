package com.api.dto.repository;

import com.api.domain.NominationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NominationRepository extends JpaRepository<NominationsEntity, Integer> {
    List<NominationsEntity> findByFilmId(Integer filmId);
}
