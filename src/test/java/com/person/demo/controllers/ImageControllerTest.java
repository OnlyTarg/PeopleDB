package com.person.demo.controllers;

import com.person.demo.services.PersonService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ImageControllerTest {
    @Mock
    PersonService personService;
    PersonController personController;


    @Before
    public void set() {
        MockitoAnnotations.initMocks(this);
        personController = new PersonController(personService);

    }




    /*@Test
    public void getImageForm() throws Exception {
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(1L);
        when(personService.findCommandById(anyLong())).thenReturn(personCommand);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        mockMvc.perform(get("/person/image/1")).
                andExpect(status().isOk()).
                andExpect(model().attributeExists("person"));
        verify(personService, times(1)).findCommandById(anyLong());
    }
    */
}
