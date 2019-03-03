package com.person.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
public class PhoneNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "Номер_телефону")
    String PhoneNumber;

}
