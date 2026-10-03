package com.leetcode.patterns.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("27. Interval DP")
class IntervalDpTest {

    @Test
    @DisplayName("burst balloons")
    void maxCoins() {
        assertEquals(167, IntervalDp.maxCoins(new int[]{3, 1, 5, 8}));
        assertEquals(10, IntervalDp.maxCoins(new int[]{1, 5}));
    }

    @Test
    @DisplayName("longest palindromic substring")
    void longestPalindrome() {
        String result = IntervalDp.longestPalindrome("babad");
        assertTrue(result.equals("bab") || result.equals("aba"));
        assertEquals("bb", IntervalDp.longestPalindrome("cbbd"));
        assertEquals("a", IntervalDp.longestPalindrome("a"));
    }
}
