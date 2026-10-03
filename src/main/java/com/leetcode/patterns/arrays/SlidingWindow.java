package com.leetcode.patterns.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern 2: Sliding Window.
 *
 * <p>Use when: contiguous subarray/substring with a constraint (longest, shortest, exactly k).
 * Both pointers only move forward, so total work is O(n).
 * Requires a monotonic validity condition; with negative numbers prefer PrefixSum.
 */
public final class SlidingWindow {

    private SlidingWindow() {
    }

    /** LONGEST valid window: expand, shrink while INVALID, then record. LC 3. */
    public static int longestSubstringWithoutRepeat(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.merge(c, 1, Integer::sum);                     // 1. expand
            while (count.get(c) > 1) {                           // 2. shrink while invalid (CHANGE)
                count.merge(s.charAt(left++), -1, Integer::sum);
            }
            best = Math.max(best, right - left + 1);             // 3. record
        }
        return best;
    }

    /** SHORTEST valid window: shrink while VALID and record inside the loop. LC 209. */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int best = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {                              // shrink while valid (CHANGE)
                best = Math.min(best, right - left + 1);
                sum -= nums[left++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    /** Fixed-size window of k: add incoming, drop outgoing. */
    public static int maxSumOfSizeK(int[] nums, int k) {
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                best = Math.max(best, sum);
            }
        }
        return best;
    }
}
