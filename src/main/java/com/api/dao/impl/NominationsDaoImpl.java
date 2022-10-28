package com.api.dao.impl;

import com.api.dao.NominationsDao;
import com.api.domain.Nomination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NominationsDaoImpl implements NominationsDao {

    private static final String FIND_ALL = "SELECT * FROM nominations";
    private static final String CREATE = "INSERT nominations(nomination, film_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE nominations SET nomination=?, film_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM nominations WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM nominations WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM nominations WHERE film_id=?";

   @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public List<Nomination> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Nomination.class));
    }

    @Override
    public Optional<Nomination> findById(Integer id) {
        Optional<Nomination> nomination;
        try{
            nomination = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Nomination.class), id));
        }
        catch (EmptyResultDataAccessException e){
            nomination = Optional.empty();
        }
        return nomination;
    }

    @Override
    public int create(Nomination nomination) {
        return jdbcTemplate.update(CREATE, nomination.getNomination(), nomination.getFilm_id());
    }

    @Override
    public int update(Integer id, Nomination nomination) {
        return jdbcTemplate.update(UPDATE, nomination.getNomination(), nomination.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
       return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Nomination> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Nomination.class), film_id);
    }
}
