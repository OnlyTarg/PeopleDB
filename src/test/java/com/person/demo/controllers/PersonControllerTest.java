package com.person.demo.controllers;

import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import com.person.demo.services.PersonService;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class PersonControllerTest {


    @Mock
    PersonService personService;


    PersonController personController;

    @Before
    public void set() {
        MockitoAnnotations.initMocks(this);
        personController = new PersonController(personService);

    }

    @Test
    public void testGetRecipe() throws Exception {
        Person person = new Person();
        person.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        when(personService.findById(anyLong())).thenReturn(person);
        mockMvc.perform(get("/person/show/1")).
                andExpect(status().isOk()).
                andExpect(view().name("person/show"));


    }


}