package com.api.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reviewers", schema = "db_jdbc_imdb", catalog = "")
public class ReviewersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "info")
    private String info;
    @Basic
    @Column(name = "film_id")
    private Integer filmId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        ReviewersEntity that = (ReviewersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(info, that.info) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, filmId);
    }
}


