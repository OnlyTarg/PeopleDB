package com.person.demo.bootstrap;

import com.person.demo.repositories.PersonsRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Test implements ApplicationListener<ContextRefreshedEvent> {
    PersonsRepository repository;
    public Test() {

       // System.out.println( "!!!!!!!!!!!!!!!!!!!!!!" + repository.findById(1L));
    }
    public Test(PersonsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
