package com.api.dto.assembler;

import com.api.controller.CashCollectionController;
import com.api.domain.CashCollectionEntity;
import com.api.dto.CashCollectionDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CashCollectionAssembler implements RepresentationModelAssembler<CashCollectionEntity, CashCollectionDto> {

    @Override
    public CashCollectionDto toModel(CashCollectionEntity entity) {
        CashCollectionDto cashCollectionDto = CashCollectionDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .build();

        Link selfLink = linkTo(methodOn(CashCollectionController.class).getById(cashCollectionDto.getId())).withSelfRel();
        cashCollectionDto.add(selfLink);
        return cashCollectionDto;
    }
}
