package com.api.service.impl;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;
import com.api.exception.ActorsAlreadyHasFilmsException;
import com.api.exception.FilmsAlreadyHasActorsException;
import com.api.exception.DoesNotHaveException;
import com.api.exception.EntityNotFoundException;
import com.api.dto.repository.ActorRepository;
import com.api.dto.repository.FilmRepository;
import com.api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class ActorsServiceImpl implements ActorService {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    FilmRepository filmRepository;


    public List<FilmsEntity> FindFilmsByActorId(Integer id) {
        ActorsEntity actors = actorRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Actors"));

        return actors.getFilms().stream().toList();
    }


    public List<ActorsEntity> findAll() {

        return  actorRepository.findAll();
    }


    public ActorsEntity findById(Integer id) {
        return  actorRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException(id, "Actors"));
    }

    @Transactional
    public ActorsEntity create(ActorsEntity entity) {
        actorRepository.save(entity);
        return entity;
    }

    @Transactional
    public void update(Integer actorId, ActorsEntity updateActor) {
        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));
        //update
        actor.setAge(updateActor.getAge());
        actor.setFullName(updateActor.getFullName());
        actor.setFilms(updateActor.getFilms());
        actorRepository.save(actor);
    }

    @Transactional
    public ActorsEntity create(ActorsEntity actor, Integer filmId) {
        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException(filmId, "Films"));

        actor.setFilms((Set<FilmsEntity>) film);
        actorRepository.save(actor);
        return actor;
    }

    @Transactional
    public void update(Integer actor_Id, ActorsEntity updateActor, Integer film_Id) {
        ActorsEntity actor = actorRepository.findById(actor_Id)
                .orElseThrow(() -> new EntityNotFoundException(actor_Id, "Actors"));

        FilmsEntity film = filmRepository.findById(film_Id)
                .orElseThrow(() -> new EntityNotFoundException(film_Id, "Films"));
        //update
        actor.setAge(updateActor.getAge());
        actor.setFullName(updateActor.getFullName());
        actor.setFilms(updateActor.getFilms());

        actor.setFilms((Set<FilmsEntity>) film);
        actorRepository.save(actor);
    }

    @Transactional
    public void delete(Integer id) {
        ActorsEntity actor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, "Actors"));
        actorRepository.delete(actor);
    }
    // -------------------------------------------------------------------------
    @Transactional
    public ActorsEntity addFilmForActor(Integer filmId, Integer actorId) {

        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));

        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException(filmId, "Films"));
        if (actor.getFilms().contains(film)) throw new ActorsAlreadyHasFilmsException(actorId, filmId);
        if (film.getActors().contains(actor)) throw new FilmsAlreadyHasActorsException(actorId, filmId);

        actor.getFilms().add(film);
        actorRepository.save(actor);
        return actor;
    }

    @Transactional
    public ActorsEntity removeFilmForActor(Integer filmId, Integer actorId) {
        ActorsEntity actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException(actorId, "Actors"));

        FilmsEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new EntityNotFoundException(filmId, "Films"));

        if (!actor.getFilms().contains(film)) throw new DoesNotHaveException(actorId, filmId, "Actors", "Films");
        actor.getFilms().remove(film);
        actorRepository.save(actor);
        return actor;
    }

    @Override
    public List<ActorsEntity> getActorsByFilmId(Integer filmId) {
        FilmsEntity films = filmRepository
                .findById(filmId).orElseThrow(() ->new EntityNotFoundException(filmId, "Films"));

        return films.getActors().stream().toList();
    }
}
