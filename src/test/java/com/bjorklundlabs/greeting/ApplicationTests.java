package com.bjorklundlabs.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private GreetingRestController greetingRestController;

	@Test
	void contextLoads() {
        assert greetingRestController != null;
	}
}
