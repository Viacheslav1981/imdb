package ru.sli.imdb.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sli.imdb.dto.PeopleDto;
import ru.sli.imdb.entities.Movies;
import ru.sli.imdb.entities.Participation;
import ru.sli.imdb.entities.People;
import ru.sli.imdb.entities.PeopleMovies;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MoviesControllerTest {

    private MoviesController moviesController;

    @DisplayName("тест, что PeopleMovies пустой массив")
    @Test
    void testEmptySet() {
        Set<PeopleMovies> peopleMoviesSet = new HashSet<>();
        Set<PeopleDto> peopleDtos = MoviesController.mapFromPeopleToPeopleDtos(peopleMoviesSet);

        assertTrue(peopleDtos.isEmpty());
    }

    @DisplayName("тест, что список со всеми заполненными полями возвращается в PeopleDtoSet")
    @Test
    void testAllFieldsPeopleMovies() {
        Set<PeopleMovies> peopleMoviesSet = new HashSet<>();

        PeopleMovies peopleMovies1 = new PeopleMovies();

        Movies movies = new Movies();
        movies.setTitle("Rambo 2");
        movies.setId(122);

        People people = new People();
        people.setId(6);
        people.setFullName("Silvester Stallone");

        Participation participation = new Participation();
        participation.setId(1);
        participation.setName("Director");

        peopleMovies1.setId(11085);
        peopleMovies1.setMovies(movies);
        peopleMovies1.setPeople(people);
        peopleMovies1.setParticipation(participation);

        peopleMoviesSet.add(peopleMovies1);

        PeopleMovies peopleMovies2 = new PeopleMovies();

        Movies movies2 = new Movies();
        movies2.setTitle("Rambo 2");
        movies2.setId(122);

        People people2 = new People();
        people2.setId(6);
        people2.setFullName("Silvester Stallone");

        Participation participation2 = new Participation();
        participation2.setId(3);
        participation2.setName("Actor");

        peopleMovies2.setId(11083);
        peopleMovies2.setMovies(movies2);
        peopleMovies2.setPeople(people2);
        peopleMovies2.setParticipation(participation2);

        peopleMoviesSet.add(peopleMovies2);

        Set<PeopleDto> peopleDtos = MoviesController.mapFromPeopleToPeopleDtos(peopleMoviesSet);

        boolean isEqualsId = false;
        boolean isEqualsFullName = false;
        boolean isEqualsParticipation = false;

        boolean isEqualsAll = false;

        for (PeopleDto pd : peopleDtos) {
            List<Participation> participationList = new ArrayList<>();
            for (PeopleMovies pm : peopleMoviesSet) {
                isEqualsId = pd.getId().equals(pm.getPeople().getId());
                isEqualsFullName = pd.getFullName().equals(pm.getPeople().getFullName());
                participationList.add(pm.getParticipation());
            }
            for (int i = 0; i < pd.getParticipation().size(); i++) {
                isEqualsParticipation = participationList.get(i).getId().equals(pd.getParticipation().get(i).getId());
            }

        }

        if (isEqualsId && isEqualsFullName && isEqualsParticipation) {
            isEqualsAll = true;
        }

        assertTrue(isEqualsAll);

    }

    @DisplayName("тест, что список упорядочен LinkedHashSet")
    @Test
    void testOrderLinkedHashSet() {
        Set<PeopleMovies> peopleMoviesSet = new LinkedHashSet<>();

        PeopleMovies peopleMovies1 = new PeopleMovies();

        Movies movies = new Movies();
        movies.setTitle("Rambo 2");
        movies.setId(122);

        People people = new People();
        people.setId(6);
        people.setFullName("Silvester Stallone");

        Participation participation = new Participation();
        participation.setId(1);
        participation.setName("Director");

        peopleMovies1.setId(11085);
        peopleMovies1.setMovies(movies);
        peopleMovies1.setPeople(people);
        peopleMovies1.setParticipation(participation);

        peopleMoviesSet.add(peopleMovies1);

        PeopleMovies peopleMovies2 = new PeopleMovies();

        Movies movies2 = new Movies();
        movies2.setTitle("The Super Movie");
        movies2.setId(121);

        People people2 = new People();
        people2.setId(11);
        people2.setFullName("Jean Cloude Van Damme");

        Participation participation2 = new Participation();
        participation2.setId(3);
        participation2.setName("Actor");

        peopleMovies2.setId(11075);
        peopleMovies2.setMovies(movies2);
        peopleMovies2.setPeople(people2);
        peopleMovies2.setParticipation(participation2);

        peopleMoviesSet.add(peopleMovies2);

        PeopleMovies peopleMovies3 = new PeopleMovies();
        People people3 = new People();
        people3.setId(12);
        people3.setFullName("Chuck Norris");

        Participation participation3 = new Participation();
        participation3.setId(3);
        participation3.setName("Actor");

        peopleMovies3.setId(110799);
        peopleMovies3.setMovies(movies2);
        peopleMovies3.setPeople(people3);
        peopleMovies3.setParticipation(participation3);

        peopleMoviesSet.add(peopleMovies3);

        Set<PeopleDto> peopleDtos = MoviesController.mapFromPeopleToPeopleDtos(peopleMoviesSet);

//
//        for (PeopleMovies pm: peopleMoviesSet) {
//            System.out.println(pm.getPeople().getId());
//
//        }
//
//        for (PeopleDto pd: peopleDtos ) {
//            System.out.println(pd.getId());
//
//        }

//
        List<Integer> compareList1PepleIdFromPeopleDto = new ArrayList<>();
        List<Integer> compareList2PepleIdFromPeopleMovies = new ArrayList<>();

        for (PeopleDto pd : peopleDtos) {
            compareList1PepleIdFromPeopleDto.add(pd.getId());
        }

        for (PeopleMovies pm : peopleMoviesSet) {
            compareList2PepleIdFromPeopleMovies.add(pm.getPeople().getId());
        }

        boolean isEquals = compareList1PepleIdFromPeopleDto.equals(compareList2PepleIdFromPeopleMovies);

        assertTrue(isEquals);

    }


}