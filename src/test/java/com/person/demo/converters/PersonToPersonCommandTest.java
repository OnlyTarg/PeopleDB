package com.person.demo.converters;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonToPersonCommandTest {
    
    PersonToPersonCommand personToPersonCommand;

    @Before
    public void setUp() throws Exception {
        personToPersonCommand = new PersonToPersonCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(personToPersonCommand.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(personToPersonCommand.convert(new Person()));
    }

    @Test
    public void convert() {
        //given
        Person person = new Person();
        person.setId(1L);
        person.setMobile("0685399549");
        person.setFirstName("Artur");
        person.setFirstName("Pirog");

        //when
        PersonCommand personCommand = personToPersonCommand.convert(person);


        //then
        assertNotNull(personCommand);
        assertEquals(person.getId(),personCommand.getId());
        assertEquals(person.getFirstName(),personCommand.getFirstName());
        assertEquals(person.getLastName(),personCommand.getLastName());
        assertEquals(person.getMobile(),personCommand.getMobile());
    }
}