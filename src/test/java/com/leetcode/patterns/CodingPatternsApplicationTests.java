package com.leetcode.patterns;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "patterns.demo.enabled=false")
@DisplayName("Application")
class CodingPatternsApplicationTests {

    @Test
    @DisplayName("Spring context loads")
    void contextLoads() {
    }

    @Test
    @DisplayName("Demo runner executes every pattern without errors")
    void demoRunnerRuns() {
        assertDoesNotThrow(() -> new PatternDemoRunner().run());
    }
}
