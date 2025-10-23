package com.bjorklundlabs.greeting.service;

import com.bjorklundlabs.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // Feature flag to control whether the counter is incremented on each greeting creation.
    // Defaults to true to preserve existing behavior when not running under Spring context.
    @Value("${greeting.counter.increment.enabled:true}")
    private boolean incrementEnabled = true;

    /**
     * Creates a greeting with an auto-incremented ID and personalized message.
     *
     * @param name the name to include in the greeting
     * @return a Greeting object with ID and content
     */
    public Greeting createGreeting(String name) {
        long id = incrementEnabled ? counter.incrementAndGet() : counter.get();
        String content = String.format(TEMPLATE, name);
        
        return Greeting.builder()
                .id(id)
                .content(content)
                .build();
    }

    /**
     * Gets the current counter value.
     *
     * @return the current counter value
     */
    public long getCurrentCount() {
        return counter.get();
    }
}
