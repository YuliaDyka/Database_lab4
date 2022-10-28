package com.api.dao.impl;

import com.api.dao.FilmsDao;
import com.api.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class FilmsDaoImpl implements FilmsDao {
    private static final String FIND_ALL = "SELECT * FROM films";
    private static final String CREATE = "INSERT films(name, date) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE films SET name=?, date=? WHERE id=?";
    private static final String DELETE = "DELETE FROM films WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM films WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM films WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Film> findByFilmName(String name) {
        Optional<Film> film;
        try {
            film = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Film.class), name));
        } catch (EmptyResultDataAccessException e) {
            film = Optional.empty();
        }
        return film;
    }

    @Override
    public List<Film> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Film.class));
    }

    @Override
    public Optional<Film> findById(Integer id) {
        Optional<Film> film;
        try {
            film = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Film.class), id));
        } catch (EmptyResultDataAccessException e) {
            film = Optional.empty();
        }
        return film;
    }

    @Override
    public int create(Film film) {
        return jdbcTemplate.update(CREATE, film.getName(), film.getDate());
    }

    @Override
    public int update(Integer id, Film film) {
        return jdbcTemplate.update(UPDATE, film.getName(), film.getDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
