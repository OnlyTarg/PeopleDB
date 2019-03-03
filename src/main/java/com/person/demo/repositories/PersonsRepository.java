package com.person.demo.repositories;

import com.person.demo.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {

}
