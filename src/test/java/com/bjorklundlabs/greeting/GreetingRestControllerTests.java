package com.bjorklundlabs.greeting;

import com.bjorklundlabs.greeting.api.GreetingRestController;
import com.bjorklundlabs.greeting.model.Greeting;
import com.bjorklundlabs.greeting.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class GreetingRestControllerTests {

    private MockMvc mockMvc;
    private GreetingService greetingService;
    private GreetingRestController controller;

    @BeforeEach
    void setup() {
        greetingService = mock(GreetingService.class);
        controller = new GreetingRestController(greetingService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnDefaultGreeting() throws Exception {
        Greeting mockGreeting = Greeting.builder()
                .id(1L)
                .content("Hello, World!")
                .build();

        when(greetingService.createGreeting("World")).thenReturn(mockGreeting);

        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("Hello, World!"));

        verify(greetingService, times(1)).createGreeting("World");
    }

    @Test
    void shouldReturnCustomGreeting() throws Exception {
        Greeting mockGreeting = Greeting.builder()
                .id(2L)
                .content("Hello, Alice!")
                .build();

        when(greetingService.createGreeting("Alice")).thenReturn(mockGreeting);

        mockMvc.perform(get("/greeting").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.content").value("Hello, Alice!"));

        verify(greetingService, times(1)).createGreeting("Alice");
    }
}