package ru.sli.imdb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.repository.PeopleRepository;
import ru.sli.imdb.service.PeopleMapper;
import ru.sli.imdb.service.PeopleService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(description = "работа с селебрити")
@RequestMapping("/people")
@RestController
public class PeopleController {

    private PeopleService peopleService;
    private PeopleMapper peopleMapper;
    private PeopleRepository peopleRepository;

    public PeopleController(PeopleService peopleService, PeopleMapper peopleMapper, PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.peopleMapper = peopleMapper;
        this.peopleRepository = peopleRepository;
    }

    @ApiOperation("список всех селебрити")
    @GetMapping()
    public List<PeopleDto> findAll() {
        List<People> people = peopleService.findAll();

        return people.stream().map(people1 -> peopleMapper.peopleToDto(people1))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public People findById(@PathVariable int id) {
        return peopleRepository.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("создание в бд нового селебрити")
    @PostMapping()
    public PeopleDto createPeople(@RequestBody @Valid PeopleDto peopleDto) {
        People people = peopleMapper.toEntity(peopleDto);
        people = peopleService.createPeople(people);

        return peopleMapper.peopleToDto(people);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("редактирование селебрити")
    @PutMapping("/{id}")
    public PeopleDto updatePeople(@RequestBody @Valid PeopleDto peopleDto, @PathVariable int id) {
        People people = peopleService.updatePeople(peopleDto,id);

        return peopleMapper.peopleToDto(people);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation("удаление селебрити")
    @DeleteMapping("/{id}")
    public void deletePeople(@PathVariable int id) {
        peopleService.deletePeople(id);
    }




}


