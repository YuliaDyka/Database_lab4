package com.api.dao.impl;

import com.api.dao.CountriesDao;
import com.api.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CountriesDaoImpl implements CountriesDao {
    private static final String FIND_ALL = "SELECT * FROM countries";
    private static final String CREATE = "INSERT countries(name) VALUES (?)";
    private static final String UPDATE = "UPDATE countries SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM countries WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM countries WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM countries WHERE name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Country.class));
    }

    @Override
    public Optional<Country> findById(Integer id) {
        Optional<Country> country;
        try {
            country = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Country.class), id));
        } catch (EmptyResultDataAccessException e) {
            country = Optional.empty();
        }
        return country;
    }

    @Override
    public int create(Country country) {
        return jdbcTemplate.update(CREATE, country.getName());
    }

    @Override
    public int update(Integer id, Country country) {
        return jdbcTemplate.update(UPDATE, country.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Country> findByCountryName(String name) {
        Optional<Country> country;
        try {
            country = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Country.class), name));
        } catch (EmptyResultDataAccessException e) {
            country = Optional.empty();
        }
        return country;
    }
}
