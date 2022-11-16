package com.api.dto.assembler;

import com.api.controller.FilmController;
import com.api.domain.FilmsEntity;
import com.api.dto.FilmDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FilmDtoAssembler implements RepresentationModelAssembler<FilmsEntity, FilmDto> {

    @Override
    public FilmDto toModel(FilmsEntity entity) {
        FilmDto filmDto = FilmDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

        Link selfLink = linkTo(methodOn(FilmController.class).getById(filmDto.getId())).withSelfRel();
        filmDto.add(selfLink);
        Link actorsLink = linkTo(methodOn(FilmController.class).getAllActorsForFilm(entity.getId())).withRel("actors");
        filmDto.add(actorsLink);
        return filmDto;
    }

    @Override
    public CollectionModel<FilmDto> toCollectionModel(Iterable<? extends FilmsEntity> entities) {
        CollectionModel<FilmDto> filmDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(FilmController.class).getAll()).withSelfRel();
        filmDtos.add(selfLink);
        return filmDtos;
    }

    public CollectionModel<FilmDto> toCollectionModel(Iterable<? extends FilmsEntity> entities, Link link) {
        CollectionModel<FilmDto> filmDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        filmDtos.add(link);
        return filmDtos;
    }
}
