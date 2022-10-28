package com.api.domain.service.impl;

import com.api.dao.NewsDao;
import com.api.domain.New;
import com.api.domain.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Override
    public List<New> findAll() {
        return newsDao.findAll();
    }

    @Override
    public Optional<New> findById(Integer id) {
        return newsDao.findById(id);
    }

    @Override
    public int create(New entity) {
        return newsDao.create(entity);
    }

    @Override
    public int update(Integer id, New entity) {
        return newsDao.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return newsDao.delete(id);
    }

    @Override
    public List<New> FindByFilmId(Integer film_id) {
        return newsDao.findByFilmId(film_id);
    }
}
