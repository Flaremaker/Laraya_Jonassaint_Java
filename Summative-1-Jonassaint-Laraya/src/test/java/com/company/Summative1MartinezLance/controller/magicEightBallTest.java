package com.company.Summative1MartinezLance.controller;

import com.company.Summative1MartinezLance.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(magicEightBallController.class)
public class magicEightBallTest {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    // testing POST /magic
    @Test
    public void shouldReturnAnswerOnValidPostRequest() throws Exception {
        // arrange
        Answer answer = new Answer("Will Elder Scrolls Six ever come out?");


        String inputJson = mapper.writeValueAsString(answer);
        String outputJson = mapper.writeValueAsString(answer);

        // act
        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated()); // 201
    }
}
