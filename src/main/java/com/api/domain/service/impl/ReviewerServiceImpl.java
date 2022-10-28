package com.api.domain.service.impl;

import com.api.dao.ReviewersDao;
import com.api.domain.Reviewer;
import com.api.domain.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewerServiceImpl implements ReviewerService {

    @Autowired
    private ReviewersDao reviewersDao;

    @Override
    public List<Reviewer> findAll() {
        return reviewersDao.findAll();
    }

    @Override
    public Optional<Reviewer> findById(Integer id) {
        return reviewersDao.findById(id);
    }

    @Override
    public int create(Reviewer reviewer) {
        return reviewersDao.create(reviewer);
    }

    @Override
    public int update(Integer id, Reviewer reviewer) {
        return reviewersDao.update(id, reviewer);
    }

    @Override
    public int delete(Integer id) {
        return reviewersDao.delete(id);
    }

    @Override
    public List<Reviewer> FindByFilmId(Integer film_id) {
        return reviewersDao.findByFilmId(film_id);
    }
}
