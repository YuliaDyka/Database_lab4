package com.api.dto.assembler;

import com.api.controller.CountryController;
import com.api.controller.FilmActorProcedureController;
import com.api.domain.CountriesEntity;
import com.api.domain.FilmactorsEntity;
import com.api.dto.CountryDto;
import com.api.dto.FilmActorDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FilmActorAssembler implements RepresentationModelAssembler<FilmactorsEntity, FilmActorDto> {

    @Override
    public FilmActorDto toModel(FilmactorsEntity entity) {
        FilmActorDto faDto = FilmActorDto.builder()
                .id(entity.getId())
                .film_id(entity.getFilmId())
                .actor_id(entity.getActorId())
                .build();

        Link selfLink = linkTo(methodOn(FilmActorProcedureController.class).getById(faDto.getId())).withSelfRel();
        faDto.add(selfLink);
        return faDto;
    }
}
