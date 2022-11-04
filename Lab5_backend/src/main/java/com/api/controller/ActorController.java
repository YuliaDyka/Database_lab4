package com.api.controller;

import com.api.domain.ActorsEntity;
import com.api.domain.FilmsEntity;
import com.api.dto.ActorDto;
import com.api.dto.FilmDto;
import com.api.dto.assembler.ActorDtoAssembler;
import com.api.dto.assembler.FilmDtoAssembler;
import com.api.service.ActorService;
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
@RequestMapping(value = "/api/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorDtoAssembler actorDtoAssembler;
    @Autowired
    private FilmDtoAssembler filmDtoAssembler;

    @GetMapping(value = "/{actorId}")
    public ResponseEntity<ActorDto> getById(@PathVariable Integer actorId) {
        ActorsEntity actor = actorService.findById(actorId);
        ActorDto personDto = actorDtoAssembler.toModel(actor);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{actorId}/films")
    public ResponseEntity<CollectionModel<FilmDto>> getAllActorsForFilm(@PathVariable Integer actorId) {
        List<FilmsEntity> films = actorService.FindFilmsByActorId(actorId);

        Link selfLink = linkTo(methodOn(FilmController.class).getAllActorsForFilm(actorId)).withSelfRel();
        CollectionModel<FilmDto> filmDtos = filmDtoAssembler.toCollectionModel(films, selfLink);
        return new ResponseEntity<>(filmDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ActorDto> add(@RequestBody ActorsEntity actor) {
        ActorsEntity newActor = actorService.create(actor);
        ActorDto actorDto = actorDtoAssembler.toModel(newActor);
        return new ResponseEntity<>(actorDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ActorsEntity upActor, @PathVariable Integer id) {
        actorService.update(id, upActor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        actorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ActorDto>> getAll() {
        List<ActorsEntity> actors = actorService.findAll();
        CollectionModel<ActorDto> actorDtos = actorDtoAssembler.toCollectionModel(actors);
        return new ResponseEntity<>(actorDtos, HttpStatus.OK);
    }


}
