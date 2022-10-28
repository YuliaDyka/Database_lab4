package com.api.dao.impl;

import com.api.dao.RaitingsDao;
import com.api.domain.Raiting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RaitingsDaoImpl implements RaitingsDao {

    private static final String FIND_ALL = "SELECT * FROM raitings";
    private static final String CREATE = "INSERT raitings(raiting, film_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE raitings SET raiting=?, film_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM raitings WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM raitings WHERE id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM raitings WHERE film_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Raiting> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Raiting.class));
    }

    @Override
        public Optional<Raiting> findById(Integer id) {
            Optional<Raiting> raiting;
            try{
                raiting = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                        BeanPropertyRowMapper.newInstance(Raiting.class), id));
            }
            catch (EmptyResultDataAccessException e){
                raiting = Optional.empty();
            }
            return raiting;
        }


    @Override
    public int create(Raiting raiting) {
        return jdbcTemplate.update(CREATE, raiting.getRaiting(), raiting.getFilm_id());
    }

    @Override
    public int update(Integer id, Raiting raiting) {
        return jdbcTemplate.update(UPDATE, raiting.getRaiting(), raiting.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Raiting> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Raiting.class), film_id);
    }
}
