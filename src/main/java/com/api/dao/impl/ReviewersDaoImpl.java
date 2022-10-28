package com.api.dao.impl;

import com.api.dao.ReviewersDao;
import com.api.domain.Reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewersDaoImpl implements ReviewersDao {
    private static final String FIND_ALL = "SELECT * FROM reviewers";
    private static final String CREATE = "INSERT reviewers(info, film_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE reviewers SET info=?, film_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM reviewers WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM reviewers WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM reviewers WHERE film_id=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Reviewer> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Reviewer.class));
    }

    @Override
    public Optional<Reviewer> findById(Integer id) {
        Optional<Reviewer> reviewer;
        try{
            reviewer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Reviewer.class), id));
        }
        catch (EmptyResultDataAccessException e){
            reviewer = Optional.empty();
        }
        return reviewer;
    }

    @Override
    public int create(Reviewer reviewer) {
        return jdbcTemplate.update(CREATE, reviewer.getInfo(), reviewer.getFilm_id());
    }

    @Override
    public int update(Integer id, Reviewer reviewer) {
        return jdbcTemplate.update(UPDATE, reviewer.getInfo(), reviewer.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Reviewer> findByFilmId(Integer film_id) {

        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Reviewer.class), film_id);

    }
}
