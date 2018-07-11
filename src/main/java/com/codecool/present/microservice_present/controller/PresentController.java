package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Present	Modify	/present/{id}	PUT	ID, Present	Present

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

    @GetMapping("/present/{id}")
    public Present getPresentById(@PathVariable("id") long id) {
        return presentService.getPresentsBy(id);
    }

    @PostMapping("/present")
    public Present addPresent(@RequestBody Present present) {
        return presentService.addPresent(present).get();
    }

    @DeleteMapping("/present/{id}")
    public HttpStatus removePresentById(@PathVariable("id") long id) {
        presentService.removePresentById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/present")
    public Present modifyPresent(@RequestBody Present present) {
        return presentService.addPresent(present).get();
    }

}
