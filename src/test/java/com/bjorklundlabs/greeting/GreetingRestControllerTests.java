package com.bjorklundlabs.greeting;

import com.bjorklundlabs.greeting.api.GreetingRestController;
import com.bjorklundlabs.greeting.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GreetingRestControllerTests {

    private MockMvc mockMvc;
    private GreetingService greetingService;

    @BeforeEach
    void setup() {
        greetingService = new GreetingService();
        GreetingRestController controller = new GreetingRestController(greetingService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnDefaultGreeting_whenIncrementEnabled() throws Exception {
        // incrementEnabled is true by default via @Value default and field default
        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    void shouldReturnDefaultGreeting_whenIncrementDisabled() throws Exception {
        // Disable increment via reflection to simulate feature flag off
        ReflectionTestUtils.setField(greetingService, "incrementEnabled", false);

        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.content").value("Hello, World!"));

        // A second call should still return id 0 when disabled
        mockMvc.perform(get("/greeting").param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(0))
                .andExpect(jsonPath("$.content").value("Hello, Alice!"));
    }
}