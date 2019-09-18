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

        personCommand.setRank(source.getRank());
        personCommand.setFirstName(source.getFirstName());
        personCommand.setLastName(source.getLastName());
        personCommand.setFatherName(source.getFatherName());
        personCommand.setMobile(source.getMobile());
        personCommand.setService(source.getService());
        personCommand.setPosition(source.getPosition());
        personCommand.setBirthday(source.getBirthday());
        return personCommand;

    }
}
