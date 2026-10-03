package com.leetcode.patterns.heap;

import com.leetcode.patterns.model.ListNode;
import java.util.PriorityQueue;

/**
 * Pattern 15: K-way Merge.
 *
 * <p>The heap holds the current head of each sorted sequence. O(N log k).
 */
public final class KWayMerge {

    private KWayMerge() {
    }

    /** LC 23. */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = node;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }

    /** Pop k times from a heap of {value, row, col}. LC 378. */
    public static int kthSmallestInSortedMatrix(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int r = 0; r < Math.min(matrix.length, k); r++) {
            heap.offer(new int[]{matrix[r][0], r, 0});
        }
        int[] top = null;
        for (int i = 0; i < k; i++) {
            top = heap.poll();
            int r = top[1];
            int c = top[2];
            if (c + 1 < matrix[r].length) {
                heap.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }
        return top[0];
    }
}
