package com.leetcode.patterns.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("26. Knapsack DP")
class KnapsackDpTest {

    @Test
    @DisplayName("0/1: partition equal subset sum")
    void canPartition() {
        assertTrue(KnapsackDp.canPartition(new int[]{1, 5, 11, 5}));
        assertFalse(KnapsackDp.canPartition(new int[]{1, 2, 3, 5}));
        assertFalse(KnapsackDp.canPartition(new int[]{1, 2, 5}));   // odd total
        assertFalse(KnapsackDp.canPartition(new int[]{2, 4}));      // item reuse would wrongly pass
    }

    @Test
    @DisplayName("0/1 count: target sum")
    void targetSum() {
        assertEquals(5, KnapsackDp.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        assertEquals(1, KnapsackDp.findTargetSumWays(new int[]{1}, 1));
        assertEquals(0, KnapsackDp.findTargetSumWays(new int[]{1}, 2));
    }

    @Test
    @DisplayName("unbounded: coin change ways (combinations)")
    void coinChangeWays() {
        assertEquals(4, KnapsackDp.coinChangeWays(5, new int[]{1, 2, 5}));
        assertEquals(0, KnapsackDp.coinChangeWays(3, new int[]{2}));
        assertEquals(1, KnapsackDp.coinChangeWays(0, new int[]{7}));
    }
}
