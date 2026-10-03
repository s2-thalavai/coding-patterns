package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("7. Kadane")
class KadaneTest {

    @Test
    @DisplayName("maxSubArray, including all-negative input")
    void maxSubArray() {
        assertEquals(6, Kadane.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, Kadane.maxSubArray(new int[]{1}));
        assertEquals(-1, Kadane.maxSubArray(new int[]{-3, -1, -2}));
    }

    @Test
    @DisplayName("maxProduct handles sign flips and zeros")
    void maxProduct() {
        assertEquals(6, Kadane.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, Kadane.maxProduct(new int[]{-2, 0, -1}));
        assertEquals(24, Kadane.maxProduct(new int[]{-2, 3, -4}));
    }
}
