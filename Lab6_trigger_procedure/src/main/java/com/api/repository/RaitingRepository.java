package com.api.repository;

import com.api.domain.RaitingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaitingRepository extends JpaRepository<RaitingsEntity, Integer>, RatingCustomRepository {
    List<RaitingsEntity> findByFilmId(Integer filmId);
}
