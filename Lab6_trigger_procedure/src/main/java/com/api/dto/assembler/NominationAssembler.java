package com.api.dto.assembler;

import com.api.controller.NominationController;
import com.api.domain.NominationsEntity;
import com.api.dto.NominationDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class NominationAssembler implements RepresentationModelAssembler<NominationsEntity, NominationDto> {

    @Override
    public NominationDto toModel(NominationsEntity entity) {
        NominationDto nominationDto = NominationDto.builder()
                .id(entity.getId())
                .nomination(entity.getNomination())
                .build();

        Link selfLink = linkTo(methodOn(NominationController.class).getById(nominationDto.getId())).withSelfRel();
        nominationDto.add(selfLink);
        return nominationDto;
    }
}