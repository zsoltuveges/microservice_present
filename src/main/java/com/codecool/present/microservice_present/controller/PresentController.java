package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PresentController {

    PresentService presentService;

    public PresentController(PresentService presentService) {
        this.presentService = presentService;
    }

    @GetMapping("/present")
    public String getAllPresents(){
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("presents", presentService.getAllPresents());
        return resultJSON.toString();
    }

    @GetMapping("/present/{id}")
    public Optional<Present> getPresentById(@PathVariable("id") long id) {
        return presentService.getPresentBy(id);
    }

    @GetMapping("/present/user/{id}")
    public String getPresentByUserId(@PathVariable("id") long id) {
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("presents", presentService.getAllPresentsByUserId(id));
        return resultJSON.toString();
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
