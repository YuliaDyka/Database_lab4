package com.api.controller.impl;

import com.api.controller.ReviewersController;
import com.api.domain.Reviewer;
import com.api.domain.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewersControllerImpl implements ReviewersController {

    @Autowired
    private ReviewerService reviewerService;

    @Override
    public List<Reviewer> findAll() {
        return reviewerService.findAll();
    }

    @Override
    public Optional<Reviewer> findById(Integer id) {
        return reviewerService.findById(id);
    }

    @Override
    public int create(Reviewer reviewer) {
        return reviewerService.create(reviewer);
    }

    @Override
    public int update(Integer id, Reviewer reviewer) {
        return reviewerService.update(id, reviewer);
    }

    @Override
    public int delete(Integer id) {
        return reviewerService.delete(id);
    }

    @Override
    public List<Reviewer> FindByFilmId(Integer film_id) {
        return reviewerService.FindByFilmId(film_id);
    }
}
