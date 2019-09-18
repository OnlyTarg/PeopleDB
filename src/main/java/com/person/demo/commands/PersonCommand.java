package com.person.demo.commands;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class PersonCommand {

    Long id;


    String firstName;
    String lastName;

    String mobile;


    String fatherName;
    String rank;
    String service;
    String position;
    String birthday;

    @Lob
    Byte[] image;


}
