package com.api.dao.impl;

import com.api.dao.Cash_collectionDao;
import com.api.domain.Cash_collection;
import com.api.domain.Reviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Cash_collectionDaoImpl implements Cash_collectionDao {

    private static final String FIND_ALL = "SELECT * FROM cash_collection";
    private static final String CREATE = "INSERT cash_collection(price, film_id, country_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE cash_collection SET price=?, film_id=?, country_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM cash_collection WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cash_collection WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM cash_collection WHERE film_id=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Cash_collection> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Cash_collection.class));
    }

    @Override
    public Optional<Cash_collection> findById(Integer id) {
        Optional<Cash_collection> cash_collection;
        try{
            cash_collection = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Cash_collection.class), id));
        }
        catch (EmptyResultDataAccessException e){
            cash_collection = Optional.empty();
        }
        return cash_collection;
    }

    @Override
    public int create(Cash_collection cash_collection) {
        return jdbcTemplate.update(CREATE, cash_collection.getPrice(), cash_collection.getFilm_id(), cash_collection.getCountry_id());
    }

    @Override
    public int update(Integer id, Cash_collection cash_collection) {
        return jdbcTemplate.update(UPDATE, cash_collection.getPrice(), cash_collection.getFilm_id(), cash_collection.getCountry_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Cash_collection> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Cash_collection.class), film_id);
    }
}
