package com.leetcode.patterns.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern 3: Prefix Sum (+ HashMap of earlier prefixes).
 *
 * <p>sum(j+1..i) = prefix[i] - prefix[j]. Works with negative numbers, unlike sliding window.
 */
public final class PrefixSum {

    private PrefixSum() {
    }

    /** Count subarrays with sum k by looking up (prefix - k). LC 560. O(n). */
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);                              // empty prefix
        int prefix = 0;
        int count = 0;
        for (int x : nums) {
            prefix += x;
            count += seen.getOrDefault(prefix - k, 0);   // query BEFORE inserting
            seen.merge(prefix, 1, Integer::sum);
        }
        return count;
    }

    /** Immutable range-sum queries in O(1) after O(n) precompute. LC 303. */
    public static final class RangeSumQuery {
        private final int[] prefix;

        public RangeSumQuery(int[] nums) {
            prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        /** Inclusive range [left, right]. */
        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }
}
