package ru.sli.imdb.service;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.entities.Movies;

@Mapper(componentModel = "spring")
public interface MoviesMapper {

    MoviesDto moviesToDto(Movies movies);

    Movies toEntity(MoviesDto moviesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Movies updateMoviesFromDto (MoviesDto moviesDto, @MappingTarget Movies movies);
}
