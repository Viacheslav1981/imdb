package ru.sli.imdb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Participation")
@Table(name = "participation", schema = "cinema")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "participation")
    private Set<PeopleMovies> peopleMovies;

    public Participation() {
    }

    public Set<PeopleMovies> getPeopleMovies() {
        return peopleMovies;
    }

    public void setPeopleMovies(Set<PeopleMovies> peopleMovies) {
        this.peopleMovies = peopleMovies;
    }

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

//    public Set<PeopleMovies> getPeopleMovies() {
//        return peopleMovies;
//    }
//
//    public void setPeopleMovies(Set<PeopleMovies> peopleMovies) {
//        this.peopleMovies = peopleMovies;
//    }
}
