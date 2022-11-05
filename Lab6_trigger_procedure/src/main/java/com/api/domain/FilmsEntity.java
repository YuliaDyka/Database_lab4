package com.api.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "films", schema = "db_jdbc_imdb", catalog = "")
public class FilmsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date")
    private String date;
    @OneToMany(mappedBy = "price")
    private List<BudgetEntity> budgets;
    @OneToMany(mappedBy = "price")
    private List<CashCollectionEntity> cashCollections;
    @OneToMany(mappedBy = "news")
    private List<NewsEntity> news;
    @OneToMany(mappedBy = "nomination")
    private List<NominationsEntity> nominations;
    @OneToMany(mappedBy = "raiting")
    private List<RaitingsEntity> raitings;
    @OneToMany(mappedBy = "info")
    private List<ReviewersEntity> reviewers;
    @ManyToMany
    @JoinTable(name = "filmactors", catalog = "", schema = "db_jdbc_imdb", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false))
    private Set<ActorsEntity> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmsEntity that = (FilmsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }

    public List<BudgetEntity> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<BudgetEntity> budgets) {
        this.budgets = budgets;
    }

    public List<CashCollectionEntity> getCashCollections() {
        return cashCollections;
    }

    public void setCashCollections(List<CashCollectionEntity> cashCollections) {
        this.cashCollections = cashCollections;
    }

    public List<NewsEntity> getNews() {
        return news;
    }

    public void setNews(List<NewsEntity> news) {
        this.news = news;
    }

    public List<NominationsEntity> getNominations() {
        return nominations;
    }

    public void setNominations(List<NominationsEntity> nominations) {
        this.nominations = nominations;
    }

    public List<RaitingsEntity> getRaitings() {
        return raitings;
    }

    public void setRaitings(List<RaitingsEntity> raitings) {
        this.raitings = raitings;
    }

    public List<ReviewersEntity> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<ReviewersEntity> reviewers) {
        this.reviewers = reviewers;
    }

    public Set<ActorsEntity> getActors() {
        return actors;
    }

    public void setActors(Set<ActorsEntity> actors) {
        this.actors = actors;
    }
}
