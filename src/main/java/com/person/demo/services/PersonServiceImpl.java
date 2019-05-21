package com.person.demo.services;

import com.person.demo.commands.PersonCommand;
import com.person.demo.converters.PersonCommandToPerson;
import com.person.demo.converters.PersonToPersonCommand;
import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

    PersonCommand personCommand;
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



    @Override
    @Transactional
    public PersonCommand savePersonCommand(PersonCommand personCommand) {
        Person person = personCommandToPerson.convert(personCommand);
        personsRepository.save(person);
        return personToPersonCommand.convert(person);
    }

    @Override
    public Set<Person> findAll() {
        Set<Person> persons = new TreeSet<>();
        Iterator<Person> iterator = personsRepository.findAll().iterator();
        while (iterator.hasNext()) {
            persons.add(iterator.next());
        }
        //it's the same, but in short
        //personsRepository.findAll().iterator().forEachRemaining(persons::add);
        return persons;
    }

    @Override
    public Person findById(Long id) throws NotFoundException {
        Optional<Person> optionalPerson = personsRepository.findById(id);
        if (!optionalPerson.isPresent()){
            throw new NotFoundException("Person with id - " + id + " not found");
        }
        return optionalPerson.get();
}

    @Override
    @Transactional
    public PersonCommand findCommandById(Long id) throws NotFoundException {
        return personToPersonCommand.convert(findById(id));
    }

    @Override
    public void deletePerson(Long id) {
        personsRepository.deleteById(id);
    }


}
