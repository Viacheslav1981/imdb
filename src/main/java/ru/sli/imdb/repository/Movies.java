package ru.sli.imdb.repository;


import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "Movies")
@Table(name = "movies", schema = "cinema")

public class Movies {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private float rating;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "people_movies", schema = "cinema",
            joinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id")
    )

    private List<People> people;

    public Movies() {

    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
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
}
