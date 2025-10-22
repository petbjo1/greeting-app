package com.bjorklundlabs.greeting;

import lombok.Builder;

@Builder
public record Greeting(long id, String content) { }
