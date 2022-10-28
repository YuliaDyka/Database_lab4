package com.api.domain.service.impl;

import com.api.dao.RaitingsDao;
import com.api.domain.Raiting;
import com.api.domain.service.RaitingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RaitingsServiceImpl implements RaitingsService {

    @Autowired
    private RaitingsDao raitingsDao;

    @Override
    public List<Raiting> findAll() {
        return raitingsDao.findAll();
    }

    @Override
    public Optional<Raiting> findById(Integer id) {
        return raitingsDao.findById(id);
    }

    @Override
    public int create(Raiting raiting) {
        return raitingsDao.create(raiting);
    }

    @Override
    public int update(Integer id, Raiting raiting) {
        return raitingsDao.update(id, raiting);
    }

    @Override
    public int delete(Integer id) {
        return raitingsDao.delete(id);
    }

    @Override
    public List<Raiting> FindByFilmId(Integer film_id) {
        return raitingsDao.findByFilmId(film_id);
    }
}
