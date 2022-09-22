package ru.sli.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.People;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {

//    @Query (value = "select m.id, m.title, m.created_at, m.modified_at, m.rating, \n" +
////            "              p.fullname, pr.name, pr.id \n" +
////            "\t\t\t from cinema.movies m, cinema.people p, cinema.people_movies pm, cinema.participation pr\n" +
////            "                 where\n" +
////            "\t\t\t\t  p.id = pm.people_id \n" +
////            "\t\t\t\t and pr.id = pm.participation_id\n" +
////            "\t\t\t\t and m.id = pm.movies_id", nativeQuery = true )

    @Query(value = "select distinct(m.id), m.title, m.created_at, m.modified_at, m.rating\n" +
            "  from cinema.movies m left join cinema.people_movies pm on m.id = pm.movies_id\n" +
            "    left join cinema.people p on p.id = pm.people_id", nativeQuery = true)

    List<Movies> findAllMovies ();


}
