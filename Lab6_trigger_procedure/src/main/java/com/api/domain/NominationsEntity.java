package com.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nominations", schema = "db_jdbc_imdb", catalog = "")
public class NominationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nomination")
    private String nomination;
    @Basic
    @Column(name = "film_id")
    private Integer filmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;
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
        NominationsEntity that = (NominationsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nomination, that.nomination) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomination, filmId);
    }
}
