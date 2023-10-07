package com.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "filmactor", collectionRelation = "filmactors")
public class FilmActorDto extends RepresentationModel<FilmActorDto> {
    private final Integer id;
    private final Integer film_id;
    private final Integer actor_id;
}
