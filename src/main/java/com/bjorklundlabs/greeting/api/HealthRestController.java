package com.bjorklundlabs.greeting.api;

import com.bjorklundlabs.greeting.model.HealthStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {

    @GetMapping("/health")
    public HealthStatus health() {
        return new HealthStatus("ok");
    }
}
