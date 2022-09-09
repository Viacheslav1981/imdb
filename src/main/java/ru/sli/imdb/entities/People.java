package ru.sli.imdb.entities;


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

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "people_movies", schema = "cinema",
//            joinColumns = @JoinColumn(name = "people_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "participation_id", referencedColumnName = "id")
//
//    )

   // @org.springframework.data.annotation.Transient
    @Transient
    private List<Participation> participation;


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

    public List<Participation> getParticipation() {
        return participation;
    }

    public void setParticipation(List<Participation> participation) {
        this.participation = participation;
    }
}
