package com.bjorklundlabs.greeting;

import com.bjorklundlabs.greeting.model.Greeting;
import com.bjorklundlabs.greeting.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTests {

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    void shouldCreateGreetingWithDefaultName() {
        Greeting greeting = greetingService.createGreeting("World");

        assertThat(greeting).isNotNull();
        assertThat(greeting.id()).isEqualTo(1L);
        assertThat(greeting.content()).isEqualTo("Hello, World!");
    }

    @Test
    void shouldCreateGreetingWithCustomName() {
        Greeting greeting = greetingService.createGreeting("Alice");

        assertThat(greeting).isNotNull();
        assertThat(greeting.id()).isEqualTo(1L);
        assertThat(greeting.content()).isEqualTo("Hello, Alice!");
    }

    @Test
    void shouldIncrementCounterOnMultipleCalls() {
        Greeting greeting1 = greetingService.createGreeting("Alice");
        Greeting greeting2 = greetingService.createGreeting("Bob");
        Greeting greeting3 = greetingService.createGreeting("Charlie");

        assertThat(greeting1.id()).isEqualTo(1L);
        assertThat(greeting2.id()).isEqualTo(2L);
        assertThat(greeting3.id()).isEqualTo(3L);
    }

    @Test
    void shouldReturnCorrectCurrentCount() {
        assertThat(greetingService.getCurrentCount()).isEqualTo(0L);

        greetingService.createGreeting("Test1");
        assertThat(greetingService.getCurrentCount()).isEqualTo(1L);

        greetingService.createGreeting("Test2");
        greetingService.createGreeting("Test3");
        assertThat(greetingService.getCurrentCount()).isEqualTo(3L);
    }

    @Test
    void shouldHandleEmptyName() {
        Greeting greeting = greetingService.createGreeting("");

        assertThat(greeting.content()).isEqualTo("Hello, !");
    }

    @Test
    void shouldHandleNullName() {
        Greeting greeting = greetingService.createGreeting(null);

        assertThat(greeting.content()).isEqualTo("Hello, null!");
    }
}