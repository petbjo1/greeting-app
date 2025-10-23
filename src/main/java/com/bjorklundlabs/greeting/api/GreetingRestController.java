package com.bjorklundlabs.greeting.api;

import com.bjorklundlabs.greeting.service.GreetingService;
import com.bjorklundlabs.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {
    private final GreetingService greetingService;

    public GreetingRestController(@Autowired GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return greetingService.createGreeting(name);
    }
}