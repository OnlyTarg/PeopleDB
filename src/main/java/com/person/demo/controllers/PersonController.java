package com.person.demo.controllers;


import com.person.demo.commands.PersonCommand;

import com.person.demo.services.PersonService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@Data
@Slf4j
public class PersonController {
    public static final String PERSON = "person";
    public static final String PERSONS = "persons";
    PersonService personService;



    @RequestMapping({"/persons","/","/index"})
    public String getAllPersons(Model model) throws NotFoundException {
        model.addAttribute(PERSONS, personService.findAll());
        log.debug("I'm at getAllPersons");
        return "/index";
    }



    @RequestMapping(value = "/person/new")
    public String newPerson(Model model) {
        model.addAttribute(PERSON, new PersonCommand());
        return "/person/personform";
    }




    /*Don't forget to add to this controller PersonCommand variable to code personService.savePersonCommand*/
    @PostMapping
    @RequestMapping(name="person")
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        personService.savePersonCommand(personCommand);
        return "redirect:/persons";
    }



    @GetMapping
    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findById(Long.valueOf(id)));
        return "person/show";
    }



    @GetMapping(value = "person/update/{id}")
    public String updatePerson(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findCommandById(Long.valueOf(id)));
        return "/person/personform";
    }

    @GetMapping(value = "person/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        personService.deletePerson(Long.valueOf(id));
        log.debug("I deleted 1 person from DB");
        return "redirect:/index";
    }




}
