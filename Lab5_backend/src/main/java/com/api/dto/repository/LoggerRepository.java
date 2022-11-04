package com.api.dto.repository;

import com.api.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Integer> {
    List<Logger> findByPersonLike(String like);
}
