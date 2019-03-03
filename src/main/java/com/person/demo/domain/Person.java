package com.person.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "Фамилия")
    String firstName;
    @Column(name = "Имя")
    String lastName;



    @OneToOne
    Notes notes;

    @OneToOne
    PhoneNumbers phoneNumbers;
















}
