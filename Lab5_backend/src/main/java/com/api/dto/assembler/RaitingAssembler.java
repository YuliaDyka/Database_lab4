package com.api.dto.assembler;

import com.api.controller.RaitingController;
import com.api.domain.RaitingsEntity;
import com.api.dto.RaitingDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RaitingAssembler implements RepresentationModelAssembler<RaitingsEntity, RaitingDto> {

    @Override
    public RaitingDto toModel(RaitingsEntity entity) {
        RaitingDto raitingDto = RaitingDto.builder()
                .id(entity.getId())
                .raiting(entity.getRaiting())
                .build();

        Link selfLink = linkTo(methodOn(RaitingController.class).getById(raitingDto.getId())).withSelfRel();
        raitingDto.add(selfLink);
        return raitingDto;
    }

}
