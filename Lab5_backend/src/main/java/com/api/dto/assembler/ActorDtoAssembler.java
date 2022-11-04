package com.api.dto.assembler;

import com.api.controller.ActorController;
import com.api.domain.ActorsEntity;
import com.api.dto.ActorDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ActorDtoAssembler implements RepresentationModelAssembler<ActorsEntity, ActorDto> {
    @Override
    public ActorDto toModel(ActorsEntity entity) {
        ActorDto actorDto = ActorDto.builder()
                .id(entity.getId())
                .age(entity.getAge())
                .build();

        Link selfLink = linkTo(methodOn(ActorController.class).getById(actorDto.getId())).withSelfRel();
        actorDto.add(selfLink);
        Link actorsLink = linkTo(methodOn(ActorController.class).getAllActorsForFilm(entity.getId())).withRel("actors");
        actorDto.add(actorsLink);
        return actorDto;
    }

    @Override
    public CollectionModel<ActorDto> toCollectionModel(Iterable<? extends ActorsEntity> entities) {
        CollectionModel<ActorDto> actorDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ActorController.class).getAll()).withSelfRel();
        actorDtos.add(selfLink);
        return actorDtos;
    }

    public CollectionModel<ActorDto> toCollectionModel(Iterable<? extends ActorsEntity> entities, Link link) {
        CollectionModel<ActorDto> actorDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        actorDto.add(link);
        return actorDto;
    }
}
