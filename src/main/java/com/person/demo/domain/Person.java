package com.person.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Person implements Comparable {

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


    @Override
    public int compareTo(Object obj) {
        Person person2 = (Person) obj;
        int result;
        if((result = id.compareTo(person2.id))==0){
            return 0;
        }
        if((result = id.compareTo(person2.id))>0){
            return 1;
        }
        if((result = id.compareTo(person2.id))<0){
            return -1;
        }
        else return 256;
    }


}
