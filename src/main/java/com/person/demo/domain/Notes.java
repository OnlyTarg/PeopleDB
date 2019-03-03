package com.person.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String notes;

    @ManyToOne
    Person person;


}