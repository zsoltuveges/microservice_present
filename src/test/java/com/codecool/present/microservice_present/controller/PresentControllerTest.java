package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PresentController.class)
public class PresentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PresentService service;

    @Test
    public void Should_ReturnPresentList_When_GetAllPresentsCalled() throws Exception{
        Present present1 = new Present("kuta", "kuta", 15, "web", "animal", 312312);
        Present present2 = new Present("cica", "cica", 10, "web", "animal", 312312);
        List<Present> presentList = new ArrayList<>();
        presentList.add(present1);
        presentList.add(present2);

        when(service.getAllPresents()).thenReturn(presentList);

        mvc.perform(get("/present")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(present1.getName())));
    }

    @Test
    public void Should_ReturnPresentObject_When_PresentObjectCalledAdd() throws Exception{
        Present present = new Present("kuta", "cica", 10, "web", "animal", 312312);

        System.out.println(asJsonString(present));
        mvc.perform(post("/present").characterEncoding("utf-8")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(present)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is(present.getName())));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}