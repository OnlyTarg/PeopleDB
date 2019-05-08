package com.person.demo.services;

import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    @Mock
    PersonsRepository personsRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);


    }

    @Test
    public void showbyID() {
        Person person = new Person();
        person.setId(1L);
        Optional<Person> optionalPerson = Optional.of(person);
        when(personsRepository.findById(anyLong())).thenReturn(optionalPerson);
        Person returned = personsRepository.findById(1L).get();
        assertNotNull("Person id Null", returned);
        verify(personsRepository, times(1)).findById(anyLong());
        verify(personsRepository, never()).findAll();
    }

}