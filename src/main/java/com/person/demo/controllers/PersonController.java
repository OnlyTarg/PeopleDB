package com.person.demo.controllers;


import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import com.person.demo.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@Controller
@AllArgsConstructor
@Data
public class PersonController {
    PersonsRepository personsRepository;
    PersonService personService;



    @RequestMapping("/persons")
    public String persons (Model model){
        model.addAttribute("persons", personsRepository.findAll());
        return "/index";
    }



    @RequestMapping(value = "/persons/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new PersonCommand());
        model.addAttribute("p",new Person());
        return "/person/personform";
    }

    @RequestMapping(name="person", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        PersonCommand saveCommand = personService.savePersonCommand(personCommand);

        return "redirect:/persons";
    }

    @RequestMapping(value = "/persons/show/{id}")
    public String showbyID(@PathVariable String id, Model model) {
        model.addAttribute("person", personsRepository.findById(new Long(id)).get());
        return "person/show";
    }




}
