package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
    public String getAllPresents() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(presentService.getAllPresents());
        objectNode.putArray("presents").addAll(arrayNode);
        return objectNode.toString();
    }

    @GetMapping("/present/{id}")
    public Present getPresentById(@PathVariable("id") long id) {
        return presentService.getPresentBy(id);
    }

    @GetMapping("/present/user/{id}")
    public String getPresentByUserId(@PathVariable("id") long id) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        ArrayNode arrayNode = objectMapper.valueToTree(presentService.getAllPresentsByUserId(id));
        objectNode.putArray("presents").addAll(arrayNode);
        return objectNode.toString();
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

    @PutMapping("/present/{id}")
    public Present modifyPresent(@PathVariable("id") long id,
                                 @RequestBody Present present) {
        return presentService.addPresent(present).get();
    }

}
