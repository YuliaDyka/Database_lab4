package com.api.dto.repository;


import com.api.domain.CashCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashCollectionRepository extends JpaRepository<CashCollectionEntity, Integer> {

    List<CashCollectionEntity> findByFilmId(Integer filmId);
}
