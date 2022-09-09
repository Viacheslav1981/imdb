package ru.sli.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sli.imdb.entities.Participation;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Integer> {

    @Query(value = "select  pm.people_id, pm.movies_id, pm.participation_id id, p.name" +
            "   from cinema.people_movies pm, cinema.participation p where " +
            " pm.movies_id = :moviesId and pm.people_id = :peopleId and pm.participation_id = p.id", nativeQuery = true)

    List<Participation> findParticipationByMoviesAndPeople(Integer moviesId, Integer peopleId);


}
