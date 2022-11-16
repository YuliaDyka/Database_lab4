package com.api.dto.assembler;

import com.api.controller.CountryInfoProcedureController;
import com.api.domain.CountryInfo;

import com.api.dto.CountryInfoDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryInfoAssembler implements RepresentationModelAssembler<CountryInfo, CountryInfoDto> {

    @Override
    public CountryInfoDto toModel(CountryInfo entity) {
        CountryInfoDto dto = CountryInfoDto.builder()
                .id(entity.getId())
                .info(entity.getInfo())
                .country_id(entity.getCountryId())
                .build();

        Link selfLink = linkTo(methodOn(CountryInfoProcedureController.class).getById(dto.getId())).withSelfRel();
        dto.add(selfLink);
        return dto;
    }
}
