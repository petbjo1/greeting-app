package com.bjorklundlabs.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class GreetingRestControllerIT {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldReturnDefaultGreeting() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"))
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    void shouldReturnCustomGreeting() throws Exception {
        mockMvc.perform(get("/greeting").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, John!"))
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    void shouldIncrementCounter() throws Exception {
        MvcResult result1 = mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult result2 = mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andReturn();

        Greeting greeting1 = objectMapper.readValue(
                result1.getResponse().getContentAsString(),
                Greeting.class
        );
        Greeting greeting2 = objectMapper.readValue(
                result2.getResponse().getContentAsString(),
                Greeting.class
        );

        assertThat(greeting2.id()).isGreaterThan(greeting1.id());
    }
}
