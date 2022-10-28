package com.api.dao.impl;

import com.api.dao.BudgetDao;
import com.api.domain.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BudgetDaoImpl implements BudgetDao {

    private static final String FIND_ALL = "SELECT * FROM budget";
    private static final String CREATE = "INSERT budget(price, film_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE budget SET price=?, film_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM budget WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM budget WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM budget WHERE film_id=?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Budget> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Budget.class), film_id);
    }

    @Override
    public List<Budget> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Budget.class));
    }

    @Override
    public Optional<Budget> findById(Integer id) {
        Optional<Budget> budget;
        try{
            budget = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Budget.class), id));
        }
        catch (EmptyResultDataAccessException e){
            budget = Optional.empty();
        }
        return budget;
    }

    @Override
    public int create(Budget budget) {
        return jdbcTemplate.update(CREATE, budget.getPrice(), budget.getFilm_id());
    }

    @Override
    public int update(Integer id, Budget budget) {
        return jdbcTemplate.update(UPDATE, budget.getPrice(), budget.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
