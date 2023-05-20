package com.ms.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.msscbeerservice.web.model.BeerDto;
import com.ms.msscbeerservice.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    private String getValidJsonBeerDto() throws JsonProcessingException {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Imperial")
                .upc(9L)
                .beerStyle(BeerStyle.LAGER)
                .price(new BigDecimal(3))
                .quantityOnHand(3)
                .build();
        return objectMapper.writeValueAsString(beerDto);
    }

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        String jsonBeer = getValidJsonBeerDto();
        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON).content(jsonBeer)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        String jsonBeer = getValidJsonBeerDto();
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(jsonBeer)).andExpect(status().isNoContent());
    }
}