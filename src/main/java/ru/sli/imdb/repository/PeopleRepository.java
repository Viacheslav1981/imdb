package ru.sli.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sli.imdb.entities.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
