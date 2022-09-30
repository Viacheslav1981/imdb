package ru.sli.imdb.dto;

import java.time.ZonedDateTime;
import java.util.Set;


public class MoviesDto {

    private Integer id;

    private String title;

    private float rating;

    private ZonedDateTime createdAt;

    private ZonedDateTime modifiedAt;

    private Set<PeopleDto> people;

    public MoviesDto() {
    }

    public Set<PeopleDto> getPeople() {
        return people;
    }

    public void setPeople(Set<PeopleDto> people) {
        this.people = people;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
//
//    public Set<People> getPeople() {
//
//        return people;
//    }
//
//    public void setPeople(Set<People> people) {
//        this.people = people;
//    }
}
