package com.person.demo.bootstrap;

import com.person.demo.domain.Person;
import com.person.demo.repositories.NotesRepositories;
import com.person.demo.repositories.PersonsRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class dataLoad implements ApplicationListener<ContextRefreshedEvent> {
    NotesRepositories notesRepositories;
    PersonsRepository personsRepository;



    public void init() {
        personsRepository.saveAll(getPersons());
    }

    public Set<Person> getPersons() {
        Set<Person> set = new HashSet<>();

        Person person = new Person();
        person.setFirstName("Pavel");
        person.setLastName("Avdonin");
        set.add(person);


        Person person1 = new Person();
        person1.setFirstName("Julia");
        person1.setLastName("Avdonina");
        set.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Strelec");
        person2.setLastName("Leonid");
        set.add(person2);

        return set;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }
}
