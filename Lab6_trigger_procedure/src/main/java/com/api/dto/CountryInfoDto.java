package com.api.dto;

import com.api.domain.CountryInfo;
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
@Relation(itemRelation = "countryInfo", collectionRelation = "countryInfos")
public class CountryInfoDto extends RepresentationModel<CountryInfo> {
    private final Integer id;
    private final String info;
    private final Integer country_id;
}
