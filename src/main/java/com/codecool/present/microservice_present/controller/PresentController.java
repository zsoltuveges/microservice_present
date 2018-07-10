package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


//Present	Add	/present	POST	Present	Present
//Present	Remove	/present/{id}	DELETE	ID	HTTP OK
//Present	Modify	/present/{id}	PUT	ID, Present	Present

//Present	Get present by ID	/present/{id}	GET	ID	Present

@Controller
public class PresentController {

    PresentService presentService;

    public PresentController(PresentService presentService) {
        this.presentService = presentService;
    }

    @GetMapping("/present")
    public List<Present> getAllPresents(){
        return presentService.getAllPresents();
    }

    @PostMapping("/present")
    public Present addPresent(@RequestBody Present present) {
        presentService.addPresent(present);
        return present;
    }



}
