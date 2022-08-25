package ru.sli.imdb.repository;


import javax.persistence.*;
import java.util.List;

@Entity(name = "People")
@Table(name = "people", schema = "cinema")

public class People {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

//  @ManyToMany(fetch = FetchType.EAGER)
////  @JoinTable(
////          name = "people_movies", schema = "cinema",
////          joinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"),
////          inverseJoinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id")
////  )
//    private List<Movies> movies;
//
//
//
    public People() {
    }
//
//    public List<Movies> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<Movies> movies) {
//        this.movies = movies;
//    }

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
}
