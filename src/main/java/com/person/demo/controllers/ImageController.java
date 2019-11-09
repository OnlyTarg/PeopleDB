package com.person.demo.controllers;

import com.person.demo.commands.PersonCommand;
import com.person.demo.services.ImageService;
import com.person.demo.services.PersonService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;


@Controller
@Slf4j
@AllArgsConstructor
@Data

public class ImageController {
    PersonService personService;
    ImageService imageService;


    @GetMapping("person/image/{id}")
    public String getImageForm(@PathVariable String id, Model model) throws NotFoundException {
        model.addAttribute("person", personService.findCommandById(Long.valueOf(id)));
        log.debug("In getImage()");
        return "person/imageuploadform";
    }

    @PostMapping("person/image/{id}")
    public String uploadImageToDB(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) throws IOException {
        imageService.saveImage(Long.valueOf(id),file);
        return "redirect:/persons";
    }

    @GetMapping("person/personimage/{id}")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException, NotFoundException {
        PersonCommand personCommand = personService.findCommandById(Long.valueOf(id));

        if (personCommand.getImage() != null) {
            byte[] byteArray = new byte[personCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : personCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);


            IOUtils.copy(is, response.getOutputStream());
        }
        else {
            File file = new File("https://dpsu.gov.ua/templates/scms_default/images/logo.png");
        Path path = file.toPath();

            byte[] bytearray= Files.readAllBytes(path);

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(bytearray);


            IOUtils.copy(is, response.getOutputStream());
        }

    }

}
