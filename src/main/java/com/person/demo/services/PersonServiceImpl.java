package com.person.demo.services;

import com.person.demo.commands.PersonCommand;
import com.person.demo.converters.PersonCommandToPerson;
import com.person.demo.converters.PersonToPersonCommand;
import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    PersonsRepository personsRepository;
    PersonCommandToPerson personCommandToPerson;
    PersonToPersonCommand personToPersonCommand;


    public PersonServiceImpl(PersonsRepository personsRepository, PersonCommandToPerson personCommandToPerson, PersonToPersonCommand personToPersonCommand) {
        this.personsRepository = personsRepository;
        this.personCommandToPerson = personCommandToPerson;
        this.personToPersonCommand = personToPersonCommand;
    }

    @Override
    public Set<Person> getPerson() {
        Set<Person> personSet =new HashSet<>();
        personsRepository.findAll().iterator().forEachRemaining(personSet::add);
        return personSet;
    }

    @Transactional
    public PersonCommand savePersonCommand(PersonCommand personCommand) {
        Person person = personCommandToPerson.convert(personCommand);
        personsRepository.save(person);
        return personToPersonCommand.convert(person);
    }


}
