package com.api.controller;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;
import com.api.dto.ActorDto;
import com.api.dto.FilmDto;
import com.api.dto.assembler.ActorDtoAssembler;
import com.api.dto.assembler.FilmDtoAssembler;
import com.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmDtoAssembler filmDtoAssembler;
    @Autowired
    private ActorDtoAssembler actorDtoAssembler;

    @GetMapping(value = "/{filmId}")
    public ResponseEntity<FilmDto> getById(@PathVariable Integer filmId) {
        FilmsEntity person = filmService.findById(filmId);
        FilmDto personDto = filmDtoAssembler.toModel(person);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{filmId}/actors")
    public ResponseEntity<CollectionModel<ActorDto>> getAllActorsForFilm(@PathVariable Integer filmId) {
        List<ActorsEntity> actors = filmService.FindActorByFilmId(filmId);

        Link selfLink = linkTo(methodOn(ActorController.class).getAllActorsForFilm(filmId)).withSelfRel();
        CollectionModel<ActorDto> actorDtos = actorDtoAssembler.toCollectionModel(actors, selfLink);
        return new ResponseEntity<>(actorDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<FilmDto> add(@RequestBody FilmsEntity film) {
        FilmsEntity newFilm = filmService.create(film);
        FilmDto filmDto = filmDtoAssembler.toModel(newFilm);
        return new ResponseEntity<>(filmDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody FilmsEntity upFilm, @PathVariable Integer id) {
        filmService.update(id, upFilm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{filmId}")
    public ResponseEntity<?> delete(@PathVariable Integer filmId) {
        filmService.delete(filmId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<FilmDto>> getAll() {
        List<FilmsEntity> films = filmService.findAll();
        CollectionModel<FilmDto> filmDtos = filmDtoAssembler.toCollectionModel(films);
        return new ResponseEntity<>(filmDtos, HttpStatus.OK);
    }


}
