package com.api.dto.assembler;

import com.api.controller.ReviewerController;
import com.api.domain.ReviewersEntity;
import com.api.dto.ReviewerDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ReviewerAssembler implements RepresentationModelAssembler<ReviewersEntity, ReviewerDto> {

    @Override
    public ReviewerDto toModel(ReviewersEntity entity) {
        ReviewerDto dto = ReviewerDto.builder()
                .id(entity.getId())
                .info(entity.getInfo())
                .build();

        Link selfLink = linkTo(methodOn(ReviewerController.class).getById(dto.getId())).withSelfRel();
        dto.add(selfLink);
        return dto;
    }
}
