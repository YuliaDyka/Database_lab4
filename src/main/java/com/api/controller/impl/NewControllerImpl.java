package com.api.controller.impl;

import com.api.controller.NewController;
import com.api.domain.New;
import com.api.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewControllerImpl implements NewController {
    @Autowired
    private NewsService newsService;

    @Override
    public List<New> findAll() {
        return newsService.findAll();
    }

    @Override
    public Optional<New> findById(Integer id) {
        return newsService.findById(id);
    }

    @Override
    public int create(New entity) {
        return newsService.create(entity);
    }

    @Override
    public int update(Integer id, New entity) {
        return newsService.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return newsService.delete(id);
    }

    @Override
    public List<New> FindByFilmId(Integer film_id) {
        return newsService.FindByFilmId(film_id);
    }
}
