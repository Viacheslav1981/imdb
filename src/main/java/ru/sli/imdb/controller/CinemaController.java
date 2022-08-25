package ru.sli.imdb.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.repository.Movies;
import ru.sli.imdb.service.MoviesMapper;
import ru.sli.imdb.service.MoviesService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(description = "работа с фильмами")
@RequestMapping("/movies")
@RestController
public class CinemaController {

    private MoviesService moviesService;
    private MoviesMapper moviesMapper;

    public CinemaController(MoviesService moviesService, MoviesMapper moviesMapper) {
        this.moviesService = moviesService;
        this.moviesMapper = moviesMapper;
    }

    @ApiOperation("список всех фильмов")
    @GetMapping()
    public List<MoviesDto> findAll() {
        List<Movies> movies = moviesService.findAll();

        return movies.stream().map(movies1 -> moviesMapper.moviesToDto(movies1))
                .collect(Collectors.toList());
    }

    @ApiOperation("один фильм со всеми участниками")
    @GetMapping("/{id}")
    public MoviesDto findWithPeople(@PathVariable Integer id) {
        return moviesMapper.moviesToDto(moviesService.findWithPeople(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("создание в бд нового фильма")
    @PostMapping()
    public MoviesDto createMovie(@RequestBody @Valid MoviesDto moviesDto) {
        Movies movies = moviesMapper.toEntity(moviesDto);
        movies = moviesService.createMovie(movies);

        return moviesMapper.moviesToDto(movies);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("редактирование фильма")
    @PutMapping("/{id}")
    public MoviesDto updateMovie(@RequestBody @Valid MoviesDto moviesDto, @PathVariable int id) {

        Movies movies = moviesService.updateMovie(moviesDto,id);

        return moviesMapper.moviesToDto(movies);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("удаление фильма")
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        moviesService.deleteMovie(id);
    }




}
