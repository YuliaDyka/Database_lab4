package com.api.dto.repository;

import com.api.domain.ActorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<ActorsEntity, Integer> {
    List<ActorsEntity> films(Integer actorId);
}
