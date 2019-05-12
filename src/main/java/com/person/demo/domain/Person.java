package com.person.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "Фамилия")
    String firstName;
    @Column(name = "Имя")
    String lastName;

    @Column(name = "Mobile")
    String mobile;


    @OneToOne
    Notes notes;

    @OneToOne
    PhoneNumbers phoneNumbers;


}
