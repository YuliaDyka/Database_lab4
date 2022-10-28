package com.api.controller.impl;

import com.api.controller.NominationsController;
import com.api.domain.Nomination;
import com.api.domain.service.NominationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NominationsControllerImpl implements NominationsController {

    @Autowired
    private NominationsService nominationsService;

    @Override
    public List<Nomination> findAll() {
        return nominationsService.findAll();
    }

    @Override
    public Optional<Nomination> findById(Integer id) {
        return nominationsService.findById(id);
    }

    @Override
    public int create(Nomination nomination) {
        return nominationsService.create(nomination);
    }

    @Override
    public int update(Integer id, Nomination nomination) {
        return nominationsService.update(id, nomination);
    }

    @Override
    public int delete(Integer id) {
        return nominationsService.delete(id);
    }

    @Override
    public List<Nomination> FindByFilmId(Integer film_id) {
        return nominationsService.FindByFilmId(film_id);
    }
}
