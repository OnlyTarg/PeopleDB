package com.person.demo.converters;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandToPerson implements Converter<PersonCommand, Person> {



    @Synchronized
    @Nullable
    @Override
    public Person convert(PersonCommand source) {
        if (source == null) {
            return null;
        }
        Person person = new Person();
        person.setId(source.getId());
        person.setFirstName(source.getFirstName());
        person.setLastName(source.getLastName());
        person.setMobile(source.getMobile());
        person.setImage(source.getImage());
        return person;
    }
}
