package com.person.demo.commands;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class PersonCommand {

    Long id;
    String firstName;
    String lastName;
    String mobile;


}
