package com.codecool.present.microservice_present.service;

import com.codecool.present.microservice_present.model.Present;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PresentService {

    public void addPresent(Present present) {

    }

    public List<Present> getAllPresents(){
        return new ArrayList<Present>();
    }
}
