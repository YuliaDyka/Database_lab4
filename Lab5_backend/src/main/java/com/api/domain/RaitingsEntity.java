package com.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "raitings", schema = "db_jdbc_imdb", catalog = "")
public class RaitingsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "raiting")
    private Integer raiting;
    @Basic
    @Column(name = "film_id")
    private Integer filmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRaiting() {
        return raiting;
    }

    public void setRaiting(Integer raiting) {
        this.raiting = raiting;
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
        RaitingsEntity that = (RaitingsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(raiting, that.raiting) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raiting, filmId);
    }
}
