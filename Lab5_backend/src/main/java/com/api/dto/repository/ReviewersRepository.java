package com.api.dto.repository;

import com.api.domain.ReviewersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewersRepository extends JpaRepository<ReviewersEntity, Integer> {
    List<ReviewersEntity> findByFilmId(Integer filmId);
}