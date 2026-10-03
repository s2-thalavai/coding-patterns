package com.leetcode.patterns.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Pattern 10: Monotonic Stack.
 *
 * <p>Keep indices in sorted value order. When a new element breaks the order, every popped
 * element has just found its next greater (or smaller) element. Each index is pushed and
 * popped once: O(n).
 */
public final class MonotonicStack {

    private MonotonicStack() {
    }

    /** Next greater: stack of indices with decreasing values. LC 739. */
    public static int[] dailyTemperatures(int[] t) {
        int[] answer = new int[t.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[stack.peek()] < t[i]) {   // CHANGE: < greater, > smaller
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        return answer;
    }

    /** Next greater element in a circular array: loop twice using i % n. LC 503. */
    public static int[] nextGreaterElementsCircular(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int x = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < x) {
                answer[stack.pop()] = x;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return answer;
    }

    /** Previous and next smaller in one pass; trailing 0 sentinel flushes the stack. LC 84. */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                int height = heights[stack.pop()];
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                best = Math.max(best, height * (i - leftBound - 1));
            }
            stack.push(i);
        }
        return best;
    }
}
