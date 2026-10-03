package com.leetcode.patterns.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern 11: Monotonic Deque.
 *
 * <p>A monotonic stack that can also expire elements from the front: the front is always
 * the max (or min) of the current window. O(n).
 */
public final class MonotonicDeque {

    private MonotonicDeque() {
    }

    /** LC 239. Deque holds indices with decreasing values. */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();                                  // 1. expired
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();                                   // 2. can never be max again
            }
            deque.offerLast(i);                                     // 3. add
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
