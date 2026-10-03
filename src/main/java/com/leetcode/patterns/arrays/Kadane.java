package com.leetcode.patterns.arrays;

/**
 * Pattern 7: Kadane's Algorithm.
 *
 * <p>cur = best subarray ending exactly here = max(start fresh, extend previous). O(n), O(1).
 */
public final class Kadane {

    private Kadane() {
    }

    /** LC 53. Initialise with nums[0] so all-negative arrays work. */
    public static int maxSubArray(int[] nums) {
        int cur = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    /** Track max AND min ending here; a negative flips them. LC 152. */
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(x, max * x);
            min = Math.min(x, min * x);
            best = Math.max(best, max);
        }
        return best;
    }
}
