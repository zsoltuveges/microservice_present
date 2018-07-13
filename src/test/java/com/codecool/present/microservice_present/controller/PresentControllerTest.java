package com.codecool.present.microservice_present.controller;

import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.service.PresentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void Should_ReturnPresentList_When_GetAllPresents() throws Exception {
        Present present1 = new Present("kuta", "kuta", 15, "web", "animal", 312312);
        Present present2 = new Present("cica", "cica", 10, "web", "animal", 312312);
        List<Present> presentList = new ArrayList<>();
        presentList.add(present1);
        presentList.add(present2);

        when(service.getAllPresents()).thenReturn(presentList);

        mvc.perform(get("/present")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.presents", hasSize(2)))
                .andExpect(jsonPath("$.presents[0].name", is(present1.getName())));
    }

    @Test
    public void Should_ReturnPresent_When_GetPresentsByID() throws Exception {
        Present present = new Present("cica", "kuta", 15, "web", "animal", 312312);

        when(service.getPresentBy(any())).thenReturn(present);

        mvc.perform(get("/present/{id}", present.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(present.getName())));
    }

    @Test
    public void Should_ReturnPresentsOfUser_When_GetPresentsByUserID() throws Exception {
        Present present1 = new Present("tonhal", "kuta", 15, "web", "animal", 312312);
        Present present2 = new Present("répa", "cica", 10, "web", "animal", 312312);
        List<Present> presentList = new ArrayList<>();
        presentList.add(present1);
        presentList.add(present2);

        when(service.getAllPresentsByUserId(1L)).thenReturn(presentList);
        ;

        mvc.perform(get("/present/user/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.presents", hasSize(2)))
                .andExpect(jsonPath("$.presents[1].name", is(present2.getName())));
    }


    @Test
    public void Should_ReturnPresentObject_When_AddPresent() throws Exception {
        Present present = new Present("kuta", "cica", 10, "web", "animal", 312312);
        present.setCreation(null);

        when(service.addPresent(any(Present.class))).thenReturn(Optional.of(present));

        System.out.println(asJsonString(present));
        mvc.perform(post("/present").characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(present)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(present.getName())));
    }

    @Test
    public void Should_ReturnPresentObject_When_ModifyPresent() throws Exception {
        Present present = new Present("kuta", "cica", 10, "web", "animal", 312312);
        present.setCreation(null);

        when(service.addPresent(any(Present.class))).thenReturn(Optional.of(present));

        System.out.println(asJsonString(present));
        mvc.perform(put("/present").characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(present)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(present.getName())));
    }

    @Test
    public void Should_HttpOK_When_RemovePresentByID() throws Exception {
        mvc.perform(delete("/present/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}