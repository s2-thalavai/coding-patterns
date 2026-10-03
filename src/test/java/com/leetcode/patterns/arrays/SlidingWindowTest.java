package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("2. Sliding Window")
class SlidingWindowTest {

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @CsvSource({"abcabcbb, 3", "bbbbb, 1", "pwwkew, 3", "'', 0", "dvdf, 3"})
    @DisplayName("longest substring without repeating characters")
    void longestSubstring(String s, int expected) {
        assertEquals(expected, SlidingWindow.longestSubstringWithoutRepeat(s));
    }

    @Test
    @DisplayName("shortest subarray with sum >= target")
    void minSubArrayLen() {
        assertEquals(2, SlidingWindow.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(0, SlidingWindow.minSubArrayLen(11, new int[]{1, 1, 1, 1}));
    }

    @Test
    @DisplayName("fixed window max sum")
    void maxSumOfSizeK() {
        assertEquals(9, SlidingWindow.maxSumOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));
        assertEquals(-1, SlidingWindow.maxSumOfSizeK(new int[]{-3, -1, -2}, 1));
    }
}
