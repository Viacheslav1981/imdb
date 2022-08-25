package ru.sli.imdb.service;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.repository.People;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    PeopleDto peopleToDto(People people);

    People toEntity(PeopleDto peopleDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    People updatePeopleFromDto (PeopleDto peopleDto, @MappingTarget People people);

}
