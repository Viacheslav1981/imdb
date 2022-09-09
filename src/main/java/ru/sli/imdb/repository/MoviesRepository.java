package ru.sli.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.People;

import java.util.List;
import java.util.Set;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {


   // @Query("select p from Post p where p.user.id=:id and p.title like :title")

    @Query(value = "select m.id, m.title, m.rating, m.created_at, " +
            " m.modified_at, p.fullname from cinema.movies m, cinema.people p, cinema.people_movies pm, cinema.participation pr\n" +
            "      where   p.id = pm.people_id\n" +
            "\t\t and pr.id = pm.participation_id", nativeQuery = true)


    List<Movies> findAllMoviesWithPeople();


}
