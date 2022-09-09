package ru.sli.imdb.dto;


import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.Participation;

import java.util.List;
import java.util.Set;


public class PeopleDto {

    private Integer id;

    private String fullName;

    private List<Movies> movies;

    private List<Participation> participation;


    public PeopleDto() {
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Participation> getParticipation() {
        return participation;
    }

    public void setParticipation(List<Participation> participation) {
        this.participation = participation;
    }

}
