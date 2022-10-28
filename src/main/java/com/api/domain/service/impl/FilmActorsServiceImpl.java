package com.api.domain.service.impl;

import com.api.dao.FilmActorsDao;
import com.api.domain.Filmactor;
import com.api.domain.service.FilmActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmActorsServiceImpl implements FilmActorsService {
    @Autowired
    private FilmActorsDao filmActorsDao;

    @Override
    public List<Filmactor> findByFilmId(Integer film_id) {
        return filmActorsDao.findByFilmId(film_id);
    }

    @Override
    public List<Filmactor> findByActorId(Integer actor_id) {
        return filmActorsDao.findByActorId(actor_id);
    }

    @Override
    public List<Filmactor> findAll() {
        return filmActorsDao.findAll();
    }

    @Override
    public Optional<Filmactor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Filmactor entity) {
        return filmActorsDao.create(entity);
    }

    @Override
    public int update(Integer id, Filmactor entity) {
        return filmActorsDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return filmActorsDao.delete(id);
    }
}
