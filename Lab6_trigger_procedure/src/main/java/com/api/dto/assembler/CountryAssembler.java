package com.api.dto.assembler;

import com.api.controller.CountryController;
import com.api.domain.CountriesEntity;
import com.api.dto.CountryDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountryAssembler implements RepresentationModelAssembler<CountriesEntity, CountryDto> {

    @Override
    public CountryDto toModel(CountriesEntity entity) {
        CountryDto countryDto = CountryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

        Link selfLink = linkTo(methodOn(CountryController.class).getById(countryDto.getId())).withSelfRel();
        countryDto.add(selfLink);
        return countryDto;
    }
}
