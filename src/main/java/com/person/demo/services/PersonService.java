package com.person.demo.services;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;

import java.util.Set;

public interface PersonService {

    Set<Person> getPerson();

    PersonCommand savePersonCommand(PersonCommand personCommand);


}
