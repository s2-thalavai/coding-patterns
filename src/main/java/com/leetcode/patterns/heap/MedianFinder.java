package com.leetcode.patterns.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Pattern 14: Two Heaps. LC 295.
 *
 * <p>Max-heap {@code low} holds the lower half, min-heap {@code high} the upper half.
 * Invariants: every low &lt;= every high, and low.size() is high.size() or high.size() + 1.
 */
public class MedianFinder {

    private final PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> high = new PriorityQueue<>();

    /** O(log n). */
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());                  // keep ordering invariant
        if (high.size() > low.size()) {
            low.offer(high.poll());              // keep size invariant
        }
    }

    /** O(1). */
    public double findMedian() {
        if (low.isEmpty()) {
            throw new IllegalStateException("No numbers added");
        }
        return low.size() > high.size()
                ? low.peek()
                : (low.peek() + (long) high.peek()) / 2.0;
    }
}
