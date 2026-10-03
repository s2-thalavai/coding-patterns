package com.leetcode.patterns.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("12. Binary Search")
class BinarySearchTest {

    private static final int[] SORTED = {1, 2, 4, 4, 5};

    @ParameterizedTest(name = "target {0}: lower={1}, upper={2}")
    @CsvSource({"0, 0, 0", "1, 0, 1", "4, 2, 4", "3, 2, 2", "5, 4, 5", "9, 5, 5"})
    @DisplayName("lower and upper bound")
    void bounds(int target, int lower, int upper) {
        assertEquals(lower, BinarySearch.lowerBound(SORTED, target));
        assertEquals(upper, BinarySearch.upperBound(SORTED, target));
    }

    @ParameterizedTest(name = "target {0} -> index {1}")
    @CsvSource({"0, 4", "4, 0", "7, 3", "2, 6", "3, -1"})
    @DisplayName("search in rotated sorted array")
    void rotated(int target, int expected) {
        assertEquals(expected, BinarySearch.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, target));
    }

    @Test
    @DisplayName("binary search on the answer")
    void kokoEatingBananas() {
        assertEquals(4, BinarySearch.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        assertEquals(30, BinarySearch.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        assertEquals(23, BinarySearch.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
