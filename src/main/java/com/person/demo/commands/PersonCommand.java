package com.person.demo.commands;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@NoArgsConstructor
@Data
public class PersonCommand {

    Long id;
    String firstName;
    String lastName;
    String mobile;
    @Lob
    Byte[] image;


}
