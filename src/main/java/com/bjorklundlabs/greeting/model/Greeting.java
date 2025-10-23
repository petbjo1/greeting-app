package com.bjorklundlabs.greeting.model;

import lombok.Builder;

@Builder
public record Greeting(long id, String content) { }
