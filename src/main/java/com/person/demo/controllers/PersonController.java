package com.person.demo.controllers;

import com.person.demo.commands.PersonCommand;
import com.person.demo.repositories.PersonsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@Data
public class PersonController {
    PersonsRepository personsRepository;

    @RequestMapping("/persons")
    public String persons (Model model){
        model.addAttribute("persons", personsRepository.findAll());
        return "persons";
    }

    @RequestMapping("/persons/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new PersonCommand());
        return "personform";
    }


}
