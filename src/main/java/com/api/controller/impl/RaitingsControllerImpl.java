package com.api.controller.impl;

import com.api.controller.RaitingsController;
import com.api.domain.Raiting;
import com.api.domain.service.RaitingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RaitingsControllerImpl implements RaitingsController {

    @Autowired
    private RaitingsService raitingsService;

    @Override
    public List<Raiting> findAll() {
        return raitingsService.findAll();
    }

    @Override
    public Optional<Raiting> findById(Integer id) {
        return raitingsService.findById(id);
    }

    @Override
    public int create(Raiting raiting) {
        return raitingsService.create(raiting);
    }

    @Override
    public int update(Integer id, Raiting raiting) {
        return raitingsService.update(id, raiting);
    }

    @Override
    public int delete(Integer id) {
        return raitingsService.delete(id);
    }

    @Override
    public List<Raiting> FindByFilmId(Integer film_id) {
        return raitingsService.FindByFilmId(film_id);
    }
}
