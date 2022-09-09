package ru.sli.imdb.entities;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "PeopleMovies")
@Table(name = "people_movies", schema = "cinema")


public class PeopleMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "movies_id")
    private Integer moviesId;

    @Column(name = "participation_id")
    private Integer participationId;

    public PeopleMovies() {
    }

    public PeopleMovies(Integer moviesId) {
        this.moviesId = moviesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Integer getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(Integer moviesId) {
        this.moviesId = moviesId;
    }

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }
}
