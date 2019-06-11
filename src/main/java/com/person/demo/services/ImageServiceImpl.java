package com.person.demo.services;

import com.person.demo.domain.Person;
import com.person.demo.repositories.PersonsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@Slf4j
@AllArgsConstructor
@Data
public class ImageServiceImpl implements ImageService {
    PersonService personService;
    PersonsRepository personsRepository;

    @Override
    @Transactional
    public void saveImage(Long id, MultipartFile file) throws IOException {
        log.debug("I'm trying to save image");
        Optional<Person> optionalPerson = personsRepository.findById(id);
        Person person = optionalPerson.get();
        byte[] byteFile = file.getBytes();

        Byte[] personFile = new Byte[byteFile.length];
        for (int i = 0; i < byteFile.length; i++) {
            personFile[i] = byteFile[i];
        }


        person.setImage(personFile);
        personsRepository.save(person);


    }
}
