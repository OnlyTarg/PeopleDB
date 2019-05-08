package com.person.demo.controllers;


import com.person.demo.commands.PersonCommand;
import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import com.person.demo.services.PersonService;
import javassist.NotFoundException;
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
    PersonService personService;



    @RequestMapping({"/persons","/","/index"})
    public String persons (Model model){
        model.addAttribute("persons", personService.findAll());
        return "/index";
    }



    @RequestMapping(value = "/person/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new PersonCommand());
        return "/person/personform";
    }

    @RequestMapping(name="person", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        PersonCommand saveCommand = personService.savePersonCommand(personCommand);

        return "redirect:/persons";
    }

    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("person", personService.findById(Long.valueOf(id)));
        return "person/show";
    }

    @RequestMapping(value = "/persons/{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("person", new PersonCommand());
        return "redirect: /person/personform";
    }




}
