package ru.sli.imdb.service;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.sli.imdb.dto.MoviesDto;
import ru.sli.imdb.entities.Movies;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-28T16:24:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (BellSoft)"
)
@Component
public class MoviesMapperImpl implements MoviesMapper {

    @Override
    public MoviesDto moviesToDto(Movies movies) {
        if ( movies == null ) {
            return null;
        }

        MoviesDto moviesDto = new MoviesDto();

        moviesDto.setId( movies.getId() );
        moviesDto.setTitle( movies.getTitle() );
        moviesDto.setRating( movies.getRating() );
        moviesDto.setCreatedAt( movies.getCreatedAt() );
        moviesDto.setModifiedAt( movies.getModifiedAt() );

        return moviesDto;
    }

    @Override
    public Movies toEntity(MoviesDto moviesDto) {
        if ( moviesDto == null ) {
            return null;
        }

        Movies movies = new Movies();

        movies.setId( moviesDto.getId() );
        movies.setTitle( moviesDto.getTitle() );
        movies.setRating( moviesDto.getRating() );
        movies.setCreatedAt( moviesDto.getCreatedAt() );
        movies.setModifiedAt( moviesDto.getModifiedAt() );

        return movies;
    }

    @Override
    public Movies updateMoviesFromDto(MoviesDto moviesDto, Movies movies) {
        if ( moviesDto == null ) {
            return null;
        }

        if ( moviesDto.getId() != null ) {
            movies.setId( moviesDto.getId() );
        }
        if ( moviesDto.getTitle() != null ) {
            movies.setTitle( moviesDto.getTitle() );
        }
        movies.setRating( moviesDto.getRating() );
        if ( moviesDto.getCreatedAt() != null ) {
            movies.setCreatedAt( moviesDto.getCreatedAt() );
        }
        if ( moviesDto.getModifiedAt() != null ) {
            movies.setModifiedAt( moviesDto.getModifiedAt() );
        }

        return movies;
    }
}
