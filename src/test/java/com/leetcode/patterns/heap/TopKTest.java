package com.leetcode.patterns.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("13. Top K Elements")
class TopKTest {

    @Test
    @DisplayName("kth largest with a size-k min-heap")
    void kthLargest() {
        assertEquals(5, TopK.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, TopK.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    @DisplayName("top k frequent, most frequent first")
    void topKFrequent() {
        assertArrayEquals(new int[]{1, 2}, TopK.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, TopK.topKFrequent(new int[]{1}, 1));
    }

    @Test
    @DisplayName("k closest points to origin")
    void kClosest() {
        int[][] result = TopK.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        Arrays.sort(result, Comparator.comparingInt((int[] p) -> p[0]));
        assertArrayEquals(new int[][]{{-2, 4}, {3, 3}}, result);
    }
}
