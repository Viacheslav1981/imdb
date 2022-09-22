package ru.sli.imdb.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.entities.PeopleMovies;
import ru.sli.imdb.repository.PeopleMoviesRepository;
import ru.sli.imdb.repository.PeopleRepository;

import java.util.List;

@Service
@Slf4j
public class PeopleService {

    private PeopleMapper peopleMapper;
    private PeopleRepository peopleRepository;
    private PeopleMoviesRepository peopleMoviesRepository;

    public PeopleService(PeopleMapper peopleMapper, PeopleRepository peopleRepository, PeopleMoviesRepository peopleMoviesRepository) {
        this.peopleMapper = peopleMapper;
        this.peopleRepository = peopleRepository;
        this.peopleMoviesRepository = peopleMoviesRepository;
    }

    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    public People findById(Integer id) {
        return peopleRepository.getById(id);
    }

    public People createPeople(People people) {
        log.info("селебрити добавлен");
        return peopleRepository.save(people);
    }

    public People updatePeople(PeopleDto peopleDto, int id) {
        People people = peopleRepository.getById(id);

        people = peopleMapper.updatePeopleFromDto(peopleDto, people);
        log.info("обновление информации о селебрити");

        return peopleRepository.save(people);
    }

    public void deletePeople(int id) {
        log.info("селеба удален");
        peopleRepository.deleteById(id);
    }



}
