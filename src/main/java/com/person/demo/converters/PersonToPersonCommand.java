package com.person.demo.converters;

import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class PersonToPersonCommand implements Converter<Person, PersonCommand> {

    @Synchronized
    @Nullable
    @Override
    public PersonCommand convert(Person source) {

        if (source == null) {
            return null;
        }

        PersonCommand personCommand = new PersonCommand();
        personCommand.setId(source.getId());
        personCommand.setFirstName(source.getFirstName());
        personCommand.setLastName(source.getLastName());
        personCommand.setMobile(source.getMobile());
        personCommand.setImage(source.getImage());
        return personCommand;

    }
}
