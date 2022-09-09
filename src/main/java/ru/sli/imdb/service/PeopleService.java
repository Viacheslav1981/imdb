package ru.sli.imdb.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.repository.PeopleRepository;

import java.util.List;

@Service
@Slf4j
public class PeopleService {

    private PeopleMapper peopleMapper;
    private PeopleRepository peopleRepository;

    public PeopleService(PeopleMapper peopleMapper, PeopleRepository peopleRepository) {
        this.peopleMapper = peopleMapper;
        this.peopleRepository = peopleRepository;
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
