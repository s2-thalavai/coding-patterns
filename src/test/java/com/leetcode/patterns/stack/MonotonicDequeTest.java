package com.leetcode.patterns.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("11. Monotonic Deque")
class MonotonicDequeTest {

    @Test
    @DisplayName("sliding window maximum")
    void maxSlidingWindow() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
                MonotonicDeque.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertArrayEquals(new int[]{1}, MonotonicDeque.maxSlidingWindow(new int[]{1}, 1));
        assertArrayEquals(new int[]{5, 4, 3},
                MonotonicDeque.maxSlidingWindow(new int[]{5, 4, 3, 2}, 2));
    }
}
