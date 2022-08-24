package ru.sli.imdb.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MoviesDto {

    private Integer id;

    private String title;

    private float rating;

    private ZonedDateTime createdAt;

    private ZonedDateTime modifiedAt;

    public MoviesDto() {
    }


}
