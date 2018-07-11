package com.codecool.present.microservice_present.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "homepage";
    }

    @GetMapping(value = "/documentation")
    public String documentation(){
        return "documentation/index.html";
    }
}
