package com.api.service.impl;

import com.api.domain.ReviewersEntity;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.ReviewersRepository;
import com.api.service.ReviewersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ReviewersServiceImpl implements ReviewersService {

    @Autowired
    ReviewersRepository reviewersRepository;

    public List<ReviewersEntity> FindByFilmId(Integer film_id) {
        return reviewersRepository.findByFilmId(film_id);
    }

    public List<ReviewersEntity> findAll() {
        return reviewersRepository.findAll();
    }

    public ReviewersEntity findById(Integer id) {
        return reviewersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Reviewer"));
    }

    @Transactional
    public ReviewersEntity create(ReviewersEntity entity) {
        return reviewersRepository.save(entity);
    }

    @Transactional
    public void update(Integer id, ReviewersEntity entity) {
        ReviewersEntity reviewers = reviewersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Reviewer"));

        reviewers.setFilmId(entity.getFilmId());
        reviewers.setInfo(entity.getInfo());
        reviewersRepository.save(reviewers);
    }

    @Transactional
    public void delete(Integer id) {
        ReviewersEntity entity = reviewersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Reviewer"));
        reviewersRepository.delete(entity);
    }
}