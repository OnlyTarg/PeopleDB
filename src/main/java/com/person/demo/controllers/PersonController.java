package com.person.demo.controllers;


import com.person.demo.commands.PersonCommand;

import com.person.demo.domain.Person;
import com.person.demo.services.PersonService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;


@Controller
@AllArgsConstructor
@Data
@Slf4j
public class PersonController {
    public static final String PERSON = "person";
    public static final String PERSONS = "persons";
    PersonService personService;



    @RequestMapping({"/persons","/","/index"})
    public String getAllPersons() throws NotFoundException {
        //model.addAttribute(PERSONS, personService.findAll());
        log.debug("I'm at getAllPersons");
        return "index.html";
    }

    @RequestMapping({"/result"})
    public String getPersons(Model model) throws NotFoundException {
        model.addAttribute(PERSONS, personService.findAll());
        log.debug("I'm at admin getAllPersons");
        return "result.html";
    }

   /* @RequestMapping({"/persons","/","/index"})
    public String getAllPersons(Model model) throws NotFoundException {
        model.addAttribute(PERSONS, personService.findByFirstName());
        log.debug("I'm at getAllPersons");
        return "index.html";
    }*/

    /*@PostMapping("/search")
    public String findByFirstName(@ModelAttribute String firstName) {
        personService.savePersonCommand(personCommand);
        log.debug("I'm in Person Post.method");
        return "redirect:/persons";
    }*/

    @GetMapping({"/search"})
    public String getPersonsByFirstName(@ModelAttribute String firstName, Model model) throws NotFoundException {
        model.addAttribute("person", new Person());
        log.debug("I'm at serachMethod");
        return "search";
    }

    @PostMapping({"/search"})
    public String submitFirstName(@ModelAttribute Person person, Model model) throws NotFoundException {
        model.addAttribute("persons", personService.findByFirstName(person.getFirstName()));
        log.debug(personService.findByFirstName(person.getFirstName()).toString());
        log.debug("I'm at serachPostMethodMethod");
        log.debug(person.getFirstName()+"Имя");
        return "result.html";
    }










    @GetMapping
    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findById(Long.valueOf(id)));
        return "person/show";
    }










}
