package ru.sli.imdb.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.entities.PeopleMovies;
import ru.sli.imdb.repository.MoviesRepository;
import ru.sli.imdb.repository.ParticipationRepository;
import ru.sli.imdb.repository.PeopleMoviesRepository;

import java.time.ZonedDateTime;
import java.util.*;

@Service
@Slf4j
public class MoviesService {

    private MoviesRepository moviesRepository;
    private MoviesMapper moviesMapper;

    private PeopleService peopleService;
    private ParticipationService participationService;

    private PeopleMoviesRepository peopleMoviesRepository;
    private ParticipationRepository participationRepository;


    public MoviesService(MoviesRepository moviesRepository, MoviesMapper moviesMapper, PeopleMoviesRepository peopleMoviesRepository, PeopleService peopleService, ParticipationService participationService, ParticipationRepository participationRepository) {
        this.moviesRepository = moviesRepository;
        this.moviesMapper = moviesMapper;
        this.peopleMoviesRepository = peopleMoviesRepository;
        this.peopleService = peopleService;
        this.participationService = participationService;
        this.participationRepository = participationRepository;
    }

    public List<Movies> findAll() {

        List<Movies> movies = moviesRepository.findAll();
        List<Movies> newListMovies = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {

            Movies movies1 = findById(movies.get(i).getId());
            newListMovies.add(movies1);

        }

        return newListMovies;
    }


    public Movies findById(Integer id) {
        Movies movies = moviesRepository.getById(id);

        List<PeopleMovies> peopleMovies = peopleMoviesRepository.findPeopleMoviesById(movies.getId());
        Set<People> peopleSet = new HashSet<>();

        for (int i = 0; i < peopleMovies.size(); i++) {


            int peopleId = peopleMovies.get(i).getPeopleId();

            People people = peopleService.findById(peopleId);

            List<Participation> participationList = participationRepository.findParticipationByMoviesAndPeople(id, peopleId);

            for (int j = 0; j < participationList.size(); j++) {
                System.out.println(participationList.get(j).getId());
                System.out.println(participationList.get(j).getName());

            }


            people.setParticipation(participationList);
            peopleSet.add(people);

        }

        movies.setPeople(peopleSet);

        return movies;
    }

    public Movies createMovie(Movies movies) {

        movies.setCreatedAt(ZonedDateTime.now());
        moviesRepository.save(movies);

//        for (People people : movies.getPeople()) {
//            for (int i = 0; i < people.getParticipation().size(); i++) {
//
//                PeopleMovies peopleMovies = new PeopleMovies();
//
//                peopleMovies.setMoviesId(movies.getId());
//                peopleMovies.setPeopleId(people.getId());
//                peopleMovies.setParticipationId(people.getParticipation().get(i).getId());
//
//                peopleMoviesRepository.save(peopleMovies);
//            }
//        }

        for (People people : movies.getPeople()) {
            for (Participation part : people.getParticipation()) {
                PeopleMovies peopleMovies = new PeopleMovies();

                peopleMovies.setPeopleId(people.getId());
                peopleMovies.setMoviesId(movies.getId());
                peopleMovies.setParticipationId(part.getId());

                peopleMoviesRepository.save(peopleMovies);

            }
//            for (int i = 0; i < people.getParticipation().size(); i++) {
//
//                PeopleMovies peopleMovies = new PeopleMovies();
//
//                peopleMovies.setMoviesId(movies.getId());
//                peopleMovies.setPeopleId(people.getId());
//                peopleMovies.setParticipationId(people.getParticipation());
//
//                peopleMoviesRepository.save(peopleMovies);
//            }
//        }


        }
        log.info("фильм добавлен");
        return movies;
    }


    public Movies updateMovie(MoviesDto moviesDto, int id) {
        Movies movies = moviesRepository.getById(id);
        movies.setModifiedAt(ZonedDateTime.now());
        movies = moviesMapper.updateMoviesFromDto(moviesDto, movies);
        // log.info("обновление информации о фильме");
        return moviesRepository.save(movies);
    }

    public void deleteMovie(int id) {
        moviesRepository.deleteById(id);
        log.info("фильм удален");
    }


}
