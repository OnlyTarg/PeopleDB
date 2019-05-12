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

    @PostMapping
    @RequestMapping(name="person")
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        PersonCommand saveCommand = personService.savePersonCommand(personCommand);

        return "redirect:/persons";
    }

    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("person", personService.findById(Long.valueOf(id)));
        return "person/show";
    }

    @GetMapping
    @RequestMapping(value = "/persons/{id}/update")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("person", new PersonCommand());
        return "redirect: /person/personform";
    }




}
