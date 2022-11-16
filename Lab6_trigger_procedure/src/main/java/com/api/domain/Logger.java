package com.api.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Logger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "person")
    private String person;
    @Basic
    @Column(name = "book")
    private String book;
    @Basic
    @Column(name = "action")
    private String action;
    @Basic
    @Column(name = "time_stamp")
    private Timestamp timeStamp;
    @Basic
    @Column(name = "user")
    private String user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logger logger = (Logger) o;
        return Objects.equals(id, logger.id) && Objects.equals(person, logger.person) && Objects.equals(book, logger.book) && Objects.equals(action, logger.action) && Objects.equals(timeStamp, logger.timeStamp) && Objects.equals(user, logger.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, book, action, timeStamp, user);
    }
}
