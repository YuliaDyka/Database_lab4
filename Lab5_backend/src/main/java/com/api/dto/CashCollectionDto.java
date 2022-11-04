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
@Relation(itemRelation = "cashCollection", collectionRelation = "cashCollections")
public class CashCollectionDto extends RepresentationModel<CashCollectionDto> {
    private final Integer id;
    private final Integer price;
    private final Integer film_id;
    private final Integer country_id;
}
