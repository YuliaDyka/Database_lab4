package com.api.dao.impl;

import com.api.dao.NewsDao;
import com.api.domain.New;
import com.api.domain.Reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsDaoImpl implements NewsDao {
    private static final String FIND_ALL = "SELECT * FROM news";
    private static final String CREATE = "INSERT news(news, film_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE news SET news=?, film_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM news WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM news WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM news WHERE film_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<New> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(New.class));
    }

    @Override
    public Optional<New> findById(Integer id) {
        Optional<New> newItem;
        try{
            newItem = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(New.class), id));
        }
        catch (EmptyResultDataAccessException e){
            newItem = Optional.empty();
        }
        return newItem;
    }

    @Override
    public int create(New entity) {
        return jdbcTemplate.update(CREATE, entity.getNews(), entity.getFilm_id());
    }

    @Override
    public int update(Integer id, New entity) {
        return jdbcTemplate.update(UPDATE, entity.getNews(), entity.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<New> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(New.class), film_id);
    }
}
