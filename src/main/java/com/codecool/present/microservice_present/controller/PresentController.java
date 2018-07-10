package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
