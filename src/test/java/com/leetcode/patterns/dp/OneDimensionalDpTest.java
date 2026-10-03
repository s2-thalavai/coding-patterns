package com.leetcode.patterns.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("24. 1D Dynamic Programming")
class OneDimensionalDpTest {

    @ParameterizedTest(name = "n={0} -> {1}")
    @CsvSource({"1, 1", "2, 2", "3, 3", "5, 8", "45, 1836311903"})
    @DisplayName("climb stairs (memoization)")
    void climbStairs(int n, int expected) {
        assertEquals(expected, OneDimensionalDp.climbStairs(n));
    }

    @Test
    @DisplayName("house robber")
    void rob() {
        assertEquals(4, OneDimensionalDp.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, OneDimensionalDp.rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(0, OneDimensionalDp.rob(new int[0]));
    }

    @Test
    @DisplayName("coin change (min coins)")
    void coinChange() {
        assertEquals(3, OneDimensionalDp.coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, OneDimensionalDp.coinChange(new int[]{2}, 3));
        assertEquals(0, OneDimensionalDp.coinChange(new int[]{1}, 0));
        assertEquals(2, OneDimensionalDp.coinChange(new int[]{1, 3, 4}, 6));   // greedy would say 3
    }

    @Test
    @DisplayName("longest increasing subsequence")
    void lis() {
        assertEquals(4, OneDimensionalDp.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, OneDimensionalDp.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        assertEquals(1, OneDimensionalDp.lengthOfLIS(new int[]{7, 7, 7, 7}));
    }

    @Test
    @DisplayName("word break")
    void wordBreak() {
        assertTrue(OneDimensionalDp.wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(OneDimensionalDp.wordBreak("applepenapple", List.of("apple", "pen")));
        assertFalse(OneDimensionalDp.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
