package com.company.Summative1MartinezLance.controller;

import com.company.Summative1MartinezLance.models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private ObjectMapper mapper = new ObjectMapper();

    private List<Quote> quoteList;

    @BeforeEach
    public void setUp() {
        quoteList = new ArrayList<>();
        quoteList.add(new Quote("This is a quote for the test","Larry",1));
        quoteList.add(new Quote("Another day another yesterday","Bary",2));
        quoteList.add(new Quote("A doctor a day keeps the apples away","Bob",3));
    }

    @Test
    public void shouldReturnQuotePositive() throws Exception{
        mockMvc.perform(get("/quote"))
                .andExpect(status().isOk()).andDo(print());

    }
}
