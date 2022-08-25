package ru.sli.imdb.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.repository.Movies;
import ru.sli.imdb.repository.MoviesRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class MoviesService {

    private MoviesRepository moviesRepository;
    private MoviesMapper moviesMapper;


    public MoviesService(MoviesRepository moviesRepository, MoviesMapper moviesMapper) {
        this.moviesRepository = moviesRepository;
        this.moviesMapper = moviesMapper;
    }

    public List<Movies> findAll() {
        return moviesRepository.findAll();
    }

    public Movies findWithPeople(Integer id) {
//        Movies movies = moviesRepository.getById(id);
//        for (int i = 0; i < movies.getPeople().size(); i++) {
//            System.out.println(movies.getPeople().get(i).getFullname());
//        }

        return moviesRepository.getById(id);
    }

    public Movies createMovie(Movies movies) {
        movies.setCreatedAt(ZonedDateTime.now());
        return moviesRepository.save(movies);
    }

    public Movies updateMovie(MoviesDto moviesDto, int id) {

        Movies movies = moviesRepository.getById(id);
        movies.setModifiedAt(ZonedDateTime.now());
        movies = moviesMapper.updateMoviesFromDto(moviesDto, movies);

        return moviesRepository.save(movies);
    }

    public void deleteMovie(int id) {
        moviesRepository.deleteById(id);
    }


}
