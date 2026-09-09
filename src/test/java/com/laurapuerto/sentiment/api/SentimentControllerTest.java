package com.laurapuerto.sentiment.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SentimentControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void analyzesSentimentThroughHttpEndpoint() throws Exception {
                mockMvc.perform(post("/sentiment")
                                .contentType("application/json")
                                .content("""
                                                {"text":"The product is excellent"}
                                                """))
                                .andExpect(status().isOk())
                                .andExpect(content().json("""
                                                {"sentiment":"POSITIVE"}
                                                """));
        }
}
