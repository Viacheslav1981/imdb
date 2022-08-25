package ru.sli.imdb.dto;


import lombok.Data;
import ru.sli.imdb.repository.Movies;

import java.util.List;


public class PeopleDto {

    private Integer id;

    private String fullname;

    private List<Movies> movies;

    public PeopleDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
