package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("3. Prefix Sum")
class PrefixSumTest {

    @Test
    @DisplayName("counts subarrays with sum k, including negatives and k = 0")
    void subarraySum() {
        assertEquals(2, PrefixSum.subarraySumEqualsK(new int[]{1, 1, 1}, 2));
        assertEquals(2, PrefixSum.subarraySumEqualsK(new int[]{1, 2, 3}, 3));
        assertEquals(3, PrefixSum.subarraySumEqualsK(new int[]{1, -1, 0}, 0));
    }

    @Test
    @DisplayName("range sum queries")
    void rangeSum() {
        PrefixSum.RangeSumQuery q = new PrefixSum.RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, q.sumRange(0, 2));
        assertEquals(-1, q.sumRange(2, 5));
        assertEquals(-3, q.sumRange(0, 5));
    }
}
