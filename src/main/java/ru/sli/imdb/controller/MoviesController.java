package ru.sli.imdb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.dto.ParticipationDto;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.entities.PeopleMovies;
import ru.sli.imdb.service.MoviesMapper;
import ru.sli.imdb.service.MoviesService;
import ru.sli.imdb.service.PeopleMapper;
import ru.sli.imdb.service.PeopleService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Api(description = "работа с фильмами")
@RequestMapping("/movies")
@RestController
public class MoviesController {

    private MoviesService moviesService;
    private MoviesMapper moviesMapper;
    private PeopleMapper peopleMapper;
    private PeopleService peopleService;

    public MoviesController(MoviesService moviesService, MoviesMapper moviesMapper, PeopleMapper peopleMapper, PeopleService peopleService) {
        this.moviesService = moviesService;
        this.moviesMapper = moviesMapper;
        this.peopleMapper = peopleMapper;
        this.peopleService = peopleService;
    }

    //
    @ApiOperation("список всех фильмов")
    @GetMapping()
    public List<MoviesDto> findAll() {
        List<Movies> movies = moviesService.findAll();

        return movies.stream().map(movies1 -> moviesMapper.moviesToDto(movies1))
                .collect(Collectors.toList());
    }

    @ApiOperation("один фильм со всеми участниками")
    @GetMapping("/{id}")
    public MoviesDto findById(@PathVariable Integer id) {

        Movies movies = moviesService.findById(id);

        Set<PeopleMovies> peopleMovies = movies.getPeopleMovies();
        Set<PeopleDto> peopleDtoSet = mapFromPeopleToPeopleDtos(peopleMovies);

        MoviesDto moviesDto = moviesMapper.moviesToDto(movies);
        moviesDto.setPeople(peopleDtoSet);

        return moviesDto;
    }

    Set<PeopleDto> mapFromPeopleToPeopleDtos(Set<PeopleMovies> peopleMovies) {
        int oldId = 0;
        Set<PeopleDto> peopleDtoSet = new HashSet<>();

        for (PeopleMovies oneRowFromPeopleMovies : peopleMovies) {

            People people = oneRowFromPeopleMovies.getPeople();

            PeopleDto peopleDto = new PeopleDto();
            peopleDto.setId(people.getId());
            peopleDto.setFullName(people.getFullName());

            if (people.getId() != oldId) {
                peopleDtoSet.add(peopleDto);
            }
            oldId = people.getId();
        }

        for (PeopleDto peopleDto : peopleDtoSet) {

            List<ParticipationDto> participationDtoList = new ArrayList<>();

            for (PeopleMovies pm : peopleMovies) {

                int peopleDtoPeopleId = peopleDto.getId();
                int peopleMoviesPeopleId = pm.getPeople().getId();

                if (peopleDtoPeopleId == peopleMoviesPeopleId) {
                    Participation participation = pm.getParticipation();
                    ParticipationDto participationDto = new ParticipationDto();
                    participationDto.setId(participation.getId());
                    participationDto.setName(participation.getName());

                    participationDtoList.add(participationDto);
                }
                peopleDto.setParticipation(participationDtoList);
            }
        }
        return peopleDtoSet;
    }


//    @ApiOperation("список всех фильмов")
//    @GetMapping()
//    public List<Movies> findAll() {
//        return moviesService.findAll();
//    }
//
//        @ApiOperation("один фильм со всеми участниками")
//    @GetMapping("/{id}")
//    public Movies findById(@PathVariable Integer id) {
//        return moviesService.findById(id);
//    }

//    @ApiOperation("список всех фильмов")
//    @GetMapping("/try")
//    public List<Movies> findAllMovies() {
//
//        return moviesService.findAllMovies();
//    }


//
//    @PreAuthorize("hasRole('ADMIN')")
//    @ApiOperation("создание в бд нового фильма")
//    @PostMapping()
//    public MoviesDto createMovie(@RequestBody @Valid MoviesDto moviesDto) {
//        Movies movies = moviesMapper.toEntity(moviesDto);
//        movies = moviesService.createMovie(movies);
//
//        return moviesMapper.moviesToDto(movies);
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("редактирование фильма")
    @PutMapping("/{id}")
    public MoviesDto updateMovie(@RequestBody @Valid MoviesDto moviesDto, @PathVariable int id) {

        Movies movies = moviesService.updateMovie(moviesDto, id);

        return moviesMapper.moviesToDto(movies);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("удаление фильма")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        moviesService.deleteMovie(id);
    }


}
