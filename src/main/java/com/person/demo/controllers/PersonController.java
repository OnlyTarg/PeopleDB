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


@Controller
@AllArgsConstructor
@Data
@Slf4j
public class PersonController {
    public static final String PERSON = "person";
    public static final String PERSONS = "persons";
    PersonService personService;


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
        log.debug(person.getFirstName() + "Имя");
        return "result.html";
    }


    @RequestMapping({"/all", "/", "/index"})
    public String getPersons(Model model) throws NotFoundException {
        model.addAttribute(PERSONS, personService.findAll());
        log.debug("I'm at admin getAllPersons");
        return "result.html";
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/person/new")
    public String newPerson(Model model) {
        model.addAttribute(PERSON, new PersonCommand());
        return "person/personform";
    }


    /*Don't forget to add to this controller PersonCommand variable to code personService.savePersonCommand*/
    @PostMapping("/person")
    public String saveOrUpdate(@ModelAttribute PersonCommand personCommand) {
        personService.savePersonCommand(personCommand);
        log.debug("I'm in Person Post.method");
        return "redirect:/all";
    }


    @GetMapping(value = "person/update/{id}")
    public String updatePerson(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findCommandById(Long.valueOf(id)));
        return "person/personform";
    }

    @GetMapping(value = "person/delete/{id}")
    public String deletePerson(@PathVariable String id) {
        personService.deletePerson(Long.valueOf(id));
        log.debug("I deleted 1 person from DB");
        return "redirect:/all";
    }

    @GetMapping
    @RequestMapping(value = "/person/show/{id}")
    public String showbyID(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute(PERSON, personService.findById(Long.valueOf(id)));
        return "person/show";
    }


}
