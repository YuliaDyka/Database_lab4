package com.api.domain.service.impl;

import com.api.dao.NominationsDao;
import com.api.domain.Nomination;
import com.api.domain.service.NominationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NominationsServiceImpl implements NominationsService {

    @Autowired
    private NominationsDao nominationsDao;

    @Override
    public List<Nomination> findAll() {
        return nominationsDao.findAll();
    }

    @Override
    public Optional<Nomination> findById(Integer id) {
        return nominationsDao.findById(id);
    }

    @Override
    public int create(Nomination nomination) {
        return nominationsDao.create(nomination);
    }

    @Override
    public int update(Integer id, Nomination nomination) {
        return nominationsDao.update(id, nomination);
    }

    @Override
    public int delete(Integer id) {
        return nominationsDao.delete(id);
    }

    @Override
    public List<Nomination> FindByFilmId(Integer film_id) {
        return nominationsDao.findByFilmId(film_id);
    }
}
