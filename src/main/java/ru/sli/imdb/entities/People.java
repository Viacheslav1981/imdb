package ru.sli.imdb.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "People")
@Table(name = "people", schema = "cinema")

public class People {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname")
    private String fullName;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "people_movies", schema = "cinema",
//            joinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "participation_id", referencedColumnName = "id")
//
//
//    )
////
  //  @org.springframework.data.annotation.Transient
   // @Transient
   // @ManyToOne(fetch = FetchType.EAGER)
  //  private List<Participation> participation;

   // @ToString.Exclude
    //@Transient

   // @JsonIgnore

   @JsonBackReference
    @OneToMany(mappedBy = "people")
    private Set<PeopleMovies> peopleMovies;

    public People() {
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

    public Set<PeopleMovies> getPeopleMovies() {
        return peopleMovies;
    }

    public void setPeopleMovies(Set<PeopleMovies> peopleMovies) {
        this.peopleMovies = peopleMovies;
    }
}
