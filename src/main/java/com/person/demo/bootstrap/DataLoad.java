package com.person.demo.bootstrap;

import com.person.demo.domain.Person;
import com.person.demo.repositories.NotesRepositories;
import com.person.demo.repositories.PersonsRepository;
import com.person.demo.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {
    NotesRepositories notesRepositories;
    PersonsRepository personsRepository;
    PersonService personService;


    public void init() {
        if(personService.findAll().size()==0) {
            personsRepository.saveAll(getPersons());
        }
    }

    public Set<Person> getPersons() {
        Set<Person> set = new HashSet<>();

        Person person = new Person();

        person.setRank("майор");
        person.setLastName("Авдонін");
        person.setFirstName("Павло");
        person.setFatherName("Олексійович");
        person.setBirthday("03.04.89");
        person.setMobile("0685399549");
        person.setService("8221");
        person.setPosition("Помічник начальника зміни ЦУС");

        set.add(person);


        Person person1 = new Person();
        person1.setRank("майор");
        person1.setLastName("Крючков");
        person1.setFirstName("Андрій");
        person1.setFatherName("Миколайович");
        person1.setBirthday("23.07.83");
        person1.setMobile("0685658595");
        person1.setService("8117");
        person1.setPosition("Начальник впс \"Білолуцьк\"");
        set.add(person1);

        Person person2 = new Person();
        person2.setRank("підполковник");
        person2.setLastName("Мартич");
        person2.setFirstName("Роман");
        person2.setFatherName("Петрович");
        person2.setBirthday("11.02.75");
        person2.setMobile("0934706243");
        person2.setService("8458");
        person2.setPosition("Начальник зміни ЦУС РуМО");
        set.add(person2);

        return set;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }
}
