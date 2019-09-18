package com.person.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data




public class Person implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @Column(name = "FirstName")
    String firstName;

    @Column(name = "LastName")
    String lastName;

    @Column(name = "Mobile")
    String mobile;




    @Column(name = "Rankk")
    String rank;

    @Column(name = "Service")
    String service;

    @Column(name = "Position")
    String position;


    @Column(name = "FatherName")
    String fatherName;

    @Column(name = "Birthday")
    String birthday;


    @OneToOne
    Notes notes;

    @OneToOne
    PhoneNumbers phoneNumbers;

    @Lob
    Byte[] image;


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
