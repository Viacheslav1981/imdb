package ru.sli.imdb.dto;


import java.util.List;


public class PeopleDto {

    private Integer id;

    private String fullName;

    private List<ParticipationDto> participation;

    public PeopleDto() {
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

    public List<ParticipationDto> getParticipation() {
        return participation;
    }

    public void setParticipation(List<ParticipationDto> participation) {
        this.participation = participation;
    }
}
