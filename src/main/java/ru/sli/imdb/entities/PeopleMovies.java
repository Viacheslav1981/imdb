package ru.sli.imdb.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

   // @JsonBackReference
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "people_id")
    People people;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "movies_id")
    Movies movies;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "participation_id")
    Participation participation;

    public PeopleMovies() {
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
}
