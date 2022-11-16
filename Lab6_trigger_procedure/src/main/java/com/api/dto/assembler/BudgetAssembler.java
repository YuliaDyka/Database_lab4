package com.api.dto.assembler;

import com.api.controller.BudgetController;
import com.api.domain.BudgetEntity;
import com.api.dto.BudgetDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BudgetAssembler implements RepresentationModelAssembler<BudgetEntity, BudgetDto> {

    @Override
    public BudgetDto toModel(BudgetEntity entity) {
        BudgetDto budgetDto = BudgetDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .build();

        Link selfLink = linkTo(methodOn(BudgetController.class).getById(budgetDto.getId())).withSelfRel();
        budgetDto.add(selfLink);
        return budgetDto;
    }
}
