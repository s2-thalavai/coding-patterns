package com.leetcode.patterns.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern 31b: Min Stack. LC 155.
 *
 * <p>Each entry stores {value, minimum so far}, so getMin is a read of the top. All O(1).
 */
public class MinStack {

    private final Deque<int[]> stack = new ArrayDeque<>();

    public void push(int x) {
        int min = stack.isEmpty() ? x : Math.min(x, stack.peek()[1]);
        stack.push(new int[]{x, min});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
