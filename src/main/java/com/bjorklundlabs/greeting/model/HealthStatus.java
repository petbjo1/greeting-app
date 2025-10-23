package com.bjorklundlabs.greeting.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple DTO representing application health.
 */
public class HealthStatus {

    @JsonProperty("health")
    private final String status;

    public HealthStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
