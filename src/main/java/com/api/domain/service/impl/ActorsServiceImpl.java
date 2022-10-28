package com.api.domain.service.impl;

import com.api.dao.ActorsDao;
import com.api.domain.Actor;
import com.api.domain.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    private ActorsDao actorsDao;

    @Override
    public List<Actor> findAll() {
        return actorsDao.findAll();
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        return actorsDao.findById(id);
    }

    @Override
    public int create(Actor entity) {
        return actorsDao.create(entity);
    }

    @Override
    public int update(Integer id, Actor entity) {
        return actorsDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return actorsDao.delete(id);
    }

    @Override
    public Optional<Actor> findByName(String name) {
        return actorsDao.findByActorName(name);
    }
}
