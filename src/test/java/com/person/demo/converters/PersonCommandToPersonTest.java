package com.person.demo.converters;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonCommandToPersonTest {
    PersonCommandToPerson personCommandToPerson;

    @Before
    public void setUp() throws Exception {
        personCommandToPerson = new PersonCommandToPerson();
    }

    @Test
    public void nullObjectTest() {
        assertNull(personCommandToPerson.convert(null));
    }

    @Test
    public void emptyObjectTest() {
        assertNotNull(personCommandToPerson.convert(new PersonCommand()));
    }

    @Test
    public void convert() {
        //given
        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(1L);
        personCommand.setFirstName("Ar");
        personCommand.setLastName("Pir");
        personCommand.setMobile("12345678");

        //when
        Person person = personCommandToPerson.convert(personCommand);

        //then
        assertNotNull(person);
        assertEquals(personCommand.getId(), person.getId());
        assertEquals(personCommand.getFirstName(), person.getFirstName());
        assertEquals(personCommand.getLastName(), person.getLastName());
        assertEquals(personCommand.getMobile(), person.getMobile());
    }
}