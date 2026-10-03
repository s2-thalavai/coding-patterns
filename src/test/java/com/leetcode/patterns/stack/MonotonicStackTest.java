package com.leetcode.patterns.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("10. Monotonic Stack")
class MonotonicStackTest {

    @Test
    @DisplayName("daily temperatures (next greater distance)")
    void dailyTemperatures() {
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                MonotonicStack.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    @Test
    @DisplayName("next greater in a circular array")
    void circular() {
        assertArrayEquals(new int[]{2, -1, 2},
                MonotonicStack.nextGreaterElementsCircular(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{2, 3, 4, -1, 4},
                MonotonicStack.nextGreaterElementsCircular(new int[]{1, 2, 3, 4, 3}));
    }

    @Test
    @DisplayName("largest rectangle in histogram")
    void histogram() {
        assertEquals(10, MonotonicStack.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(4, MonotonicStack.largestRectangleArea(new int[]{2, 4}));
        assertEquals(6, MonotonicStack.largestRectangleArea(new int[]{2, 2, 2}));
    }
}
