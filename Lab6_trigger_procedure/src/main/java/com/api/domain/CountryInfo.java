package com.api.domain;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@NamedStoredProcedureQuery(
        name = "addCountryInfoByProcedure",
        procedureName = "add_country_info",
        resultClasses = CountryInfo.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_country_id", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_info", type = String.class),
        })
public class CountryInfo extends RepresentationModel<CountryInfo> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "info")
    private String info;
    @Basic
    @Column(name = "country_id")
    private Integer countryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryInfo that = (CountryInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(info, that.info) && Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, countryId);
    }
}