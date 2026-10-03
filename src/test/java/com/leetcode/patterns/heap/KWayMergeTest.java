package com.leetcode.patterns.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.leetcode.patterns.model.ListNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("15. K-way Merge")
class KWayMergeTest {

    @Test
    @DisplayName("merge k sorted lists, tolerating nulls")
    void mergeKLists() {
        ListNode merged = KWayMerge.mergeKLists(new ListNode[]{
            ListNode.of(1, 4, 5), null, ListNode.of(1, 3, 4), ListNode.of(2, 6)});
        assertEquals(List.of(1, 1, 2, 3, 4, 4, 5, 6), ListNode.toList(merged));
        assertNull(KWayMerge.mergeKLists(new ListNode[0]));
    }

    @Test
    @DisplayName("kth smallest in a sorted matrix")
    void kthSmallest() {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        assertEquals(13, KWayMerge.kthSmallestInSortedMatrix(matrix, 8));
        assertEquals(1, KWayMerge.kthSmallestInSortedMatrix(matrix, 1));
    }
}
