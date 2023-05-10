package com.ms.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    private String getJsonBeer() throws JsonProcessingException {
        BeerDto beerDto = BeerDto.builder().build();
        return objectMapper.writeValueAsString(beerDto);
    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        String jsonBeer = getJsonBeer();
        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(jsonBeer)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        String jsonBeer = getJsonBeer();
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(jsonBeer)).andExpect(status().isNoContent());
    }
}