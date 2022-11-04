package com.api.service.impl;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;
import com.api.exception.ActorsAlreadyHasFilmsException;
import com.api.exception.FilmsAlreadyHasActorsException;
import com.api.exception.DoesNotHaveException;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.ActorRepository;
import com.api.dto.repository.FilmRepository;
import com.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class FilmsServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;



    public List<ActorsEntity> FindActorByFilmId(Integer id) {
        FilmsEntity films = filmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Films"));
        return films.getActors().stream().toList();
    }

    public List<FilmsEntity> findAll() {

        return  filmRepository.findAll();
    }

    public FilmsEntity findById(Integer id) {
        return  filmRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Films"));
    }


    // -------------------------------------------------------------------------
    @Transactional
    public FilmsEntity addActorForFilm(Integer filmId, Integer actorId) {
        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));;

        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException(filmId, "Films"));

        if (actor.getFilms().contains(film)) throw new ActorsAlreadyHasFilmsException(actorId, filmId);
        if (film.getActors().contains(actor)) throw new FilmsAlreadyHasActorsException(actorId, filmId);

        film.getActors().add(actor);
        filmRepository.save(film);
        return film;
    }


    @Transactional
    public FilmsEntity removeActorForFilm(Integer filmId, Integer actorId) {
        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() ->  new EntityNotFoundException(actorId, "Actors"));

        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() ->  new EntityNotFoundException(filmId, "Films"));
        if (!film.getActors().contains(actor))throw new DoesNotHaveException(actorId, filmId, "Films", "Actors");
        actor.getFilms().remove(film);
        actorRepository.save(actor);
        return film;
    }

    @Transactional
    public List<FilmsEntity> getFilmsByActorId(Integer actorId) {
        ActorsEntity actor = actorRepository.findById(actorId).orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));
        return actor.getFilms().stream().toList();
    }

    @Transactional
    public FilmsEntity create(FilmsEntity entity) {
        filmRepository.save(entity);
        return entity;
    }

    @Transactional
    public void update(Integer filmId, FilmsEntity updateFilm) {
        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException(filmId, "Films"));
        //update
        film.setActors(updateFilm.getActors());
        film.setName(updateFilm.getName());
        filmRepository.save(film);
    }

    @Transactional
    public void delete(Integer id) {
        FilmsEntity film = filmRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Films"));
        filmRepository.delete(film);
    }

    @Transactional
    public FilmsEntity create(FilmsEntity film, Integer actorId) {
        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));

        film.setActors((Set<ActorsEntity>) actor);
        filmRepository.save(film);
        return film;
    }

}

