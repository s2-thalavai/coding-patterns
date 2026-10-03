package com.leetcode.patterns.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("31b. Min Stack")
class MinStackTest {

    @Test
    @DisplayName("min is restored after pops, including duplicates")
    void minTracking() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin());
        stack.pop();
        assertEquals(0, stack.top());
        assertEquals(-2, stack.getMin());

        stack.push(-2);
        stack.pop();
        assertEquals(-2, stack.getMin());
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
