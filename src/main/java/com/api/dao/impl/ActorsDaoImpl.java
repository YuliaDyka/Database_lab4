package com.api.dao.impl;

import com.api.dao.ActorsDao;
import com.api.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ActorsDaoImpl implements ActorsDao {

    private static final String FIND_ALL = "SELECT * FROM actors";
    private static final String CREATE = "INSERT actors(full_name, age) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE actors SET full_name=?, age=? WHERE id=?";
    private static final String DELETE = "DELETE FROM actors WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM actors WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM actors WHERE full_name=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Actor> findByActorName(String name) {
        Optional<Actor> actor;
        try {
            actor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Actor.class), name));
        } catch (EmptyResultDataAccessException e) {
            actor = Optional.empty();
        }
        return actor;
    }

    @Override
    public List<Actor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Actor.class));
    }

    @Override
    public Optional<Actor> findById(Integer id) {
        Optional<Actor> actor;
        try {
            actor = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Actor.class), id));
        } catch (EmptyResultDataAccessException e) {
            actor = Optional.empty();
        }
        return actor;
    }

    @Override
    public int create(Actor entity) {
        return jdbcTemplate.update(CREATE, entity.getFull_name(), entity.getAge());
    }

    @Override
    public int update(Integer id, Actor entity) {
        return jdbcTemplate.update(UPDATE, entity.getFull_name(), entity.getAge(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
