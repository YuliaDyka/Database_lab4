package com.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CashCollectionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "film_id")
    private Integer filmId;
    @Basic
    @Column(name = "country_id")
    private Integer countryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
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
        CashCollectionEntity that = (CashCollectionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price) && Objects.equals(filmId, that.filmId) && Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, filmId, countryId);
    }
}
