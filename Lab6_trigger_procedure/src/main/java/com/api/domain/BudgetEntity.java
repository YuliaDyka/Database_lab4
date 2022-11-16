package com.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "budget", schema = "db_jdbc_imdb", catalog = "")
public class BudgetEntity {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetEntity that = (BudgetEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, filmId);
    }
}
