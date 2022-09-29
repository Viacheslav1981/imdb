package ru.sli.imdb.dto;


public class ParticipationDto {

    private int id;
    private String name;


    public ParticipationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
