package ru.sli.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.entities.PeopleMovies;

import java.util.List;

@Repository
public interface PeopleMoviesRepository extends JpaRepository<PeopleMovies, Integer> {

//    @Query(value = "select m.id, m.title, m.rating, m.created_at, " +
//            " m.modified_at, p.fullname from cinema.movies m, cinema.people p, cinema.people_movies pm, cinema.participation pr\n" +
//            "      where   p.id = pm.people_id\n" +
//            "\t\t and pr.id = pm.participation_id", nativeQuery = true)

    @Query(value = "SELECT pm.movies_id, pm.people_id, pm.id, pm.participation_id " +
            "FROM cinema.people_movies pm WHERE pm.movies_id = :id", nativeQuery = true)

    List<PeopleMovies> findPeopleMoviesById(Integer id);


}
