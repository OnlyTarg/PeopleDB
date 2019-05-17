package com.person.demo.controllers;


import com.person.demo.commands.PersonCommand;

import com.person.demo.services.PersonService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@Data
public class PersonController {
    public static final String PERSON = "person";
    public static final String PERSONS = "persons";
    PersonService personService;



    @RequestMapping({"/persons","/","/index"})
    public String getAllPersons(Model model){
        model.addAttribute(PERSONS, personService.findAll());
        return "/index";
    }



    @RequestMapping(value = "/person/new")
    public String newPerson(Model model) {
        model.addAttribute(PERSON, new PersonCommand());
        return "/person/personform";
    }

    @PostMapping
    @RequestMapping(name="person")
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        personService.savePersonCommand(personCommand);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findById(Long.valueOf(id)));
        return "person/show";
    }



    @GetMapping("person/update/{id}")
    public String updateRecipe(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findCommandById(Long.valueOf(id)));
        return "/person/personform";
    }




}
