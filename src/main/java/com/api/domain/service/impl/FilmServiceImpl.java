package com.api.domain.service.impl;

import com.api.dao.FilmsDao;
import com.api.domain.Film;
import com.api.domain.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmsDao filmsDao;

    @Override
    public List<Film> findAll() {
        return filmsDao.findAll();
    }

    @Override
    public Optional<Film> findById(Integer id) {
        return filmsDao.findById(id);
    }

    @Override
    public int create(Film film) {
        return filmsDao.create(film);
    }

    @Override
    public int update(Integer id, Film film) {
        return filmsDao.update(id, film);
    }

    @Override
    public int delete(Integer id) {
        return filmsDao.delete(id);
    }

    @Override
    public Optional<Film> findByName(String name) {
        return filmsDao.findByFilmName(name);
    }

}
