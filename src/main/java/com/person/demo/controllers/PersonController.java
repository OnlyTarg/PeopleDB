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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
@Data
public class PersonController {
    PersonsRepository personsRepository;
    PersonService personService;



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

    @RequestMapping(name="person", method = RequestMethod.POST)
    public String saveOrUodate(@ModelAttribute PersonCommand personCommand) {
        PersonCommand savaCommand = personService.savePersonCommand(personCommand);

        return "redirect:/persons";
    }


}
