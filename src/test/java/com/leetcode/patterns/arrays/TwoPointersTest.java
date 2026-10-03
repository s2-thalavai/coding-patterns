package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("1. Two Pointers")
class TwoPointersTest {

    @Test
    @DisplayName("twoSumSorted finds the pair")
    void twoSumSorted() {
        assertArrayEquals(new int[]{0, 1}, TwoPointers.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{-1, -1}, TwoPointers.twoSumSorted(new int[]{1, 2}, 10));
    }

    @Test
    @DisplayName("removeDuplicates compacts in place")
    void removeDuplicates() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = TwoPointers.removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, java.util.Arrays.copyOf(nums, k));
        assertEquals(0, TwoPointers.removeDuplicates(new int[0]));
    }

    @Test
    @DisplayName("threeSum returns unique triplets")
    void threeSum() {
        assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                TwoPointers.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertEquals(List.of(List.of(0, 0, 0)), TwoPointers.threeSum(new int[]{0, 0, 0, 0}));
        assertTrue(TwoPointers.threeSum(new int[]{0, 1, 1}).isEmpty());
    }
}
