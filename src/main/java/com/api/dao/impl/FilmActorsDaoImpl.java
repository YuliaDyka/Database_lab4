package com.api.dao.impl;

import com.api.dao.FilmActorsDao;
import com.api.domain.Filmactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class FilmActorsDaoImpl implements FilmActorsDao {
    private static final String FIND_ALL = "SELECT * FROM filmactors";
    private static final String CREATE = "INSERT filmactors(film_id, actor_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE filmactors SET film_id=?, actor_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM filmactors WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM filmactors WHERE id=?";
    private static final String FIND_BY_ACTOR_ID = "SELECT * FROM filmactors WHERE actor_id=?";
    private static final String FIND_BY_FILM_ID = "SELECT * FROM filmactors WHERE film_id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Filmactor> findByFilmId(Integer film_id) {
        return jdbcTemplate.query(FIND_BY_FILM_ID, BeanPropertyRowMapper.newInstance(Filmactor.class), film_id);
    }

    @Override
    public List<Filmactor> findByActorId(Integer actor_id) {
        return jdbcTemplate.query(FIND_BY_ACTOR_ID, BeanPropertyRowMapper.newInstance(Filmactor.class), actor_id);
    }

    @Override
    public List<Filmactor> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Filmactor.class));
    }

    @Override
    public Optional<Filmactor> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public int create(Filmactor entity) {
        return jdbcTemplate.update(CREATE, entity.getActor_id(), entity.getFilm_id());
    }

    @Override
    public int update(Integer id, Filmactor entity) {
        return jdbcTemplate.update(UPDATE, entity.getActor_id(), entity.getFilm_id(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

//    @Override
//    public String addFilmToActors(Integer film_id, Integer actor_id) {
//        return null;
//    }
}
