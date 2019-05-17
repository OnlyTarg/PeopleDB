package com.person.demo.services;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import javassist.NotFoundException;

import java.util.Set;

public interface PersonService {

    Set<Person> getPerson();

    PersonCommand savePersonCommand(PersonCommand personCommand);
    Set<Person> findAll();
    Person findById(Long id) throws NotFoundException;

    PersonCommand findCommandById(Long id) throws NotFoundException;


}
