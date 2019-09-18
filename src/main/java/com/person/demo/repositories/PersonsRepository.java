package com.person.demo.repositories;

import com.person.demo.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PersonsRepository extends CrudRepository<Person, Long> {
    Set<Person> findPersonByFirstName(String firstName);

}
