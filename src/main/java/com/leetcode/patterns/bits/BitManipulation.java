package com.leetcode.patterns.bits;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern 29: Bit Manipulation.
 *
 * <pre>
 * x &amp; (x - 1)   clears the lowest set bit
 * x &amp; -x        isolates the lowest set bit
 * (x &gt;&gt; i) &amp; 1  tests bit i
 * a ^ a = 0, a ^ 0 = a
 * </pre>
 * Use {@code >>>} for unsigned shifts and {@code 1L << n} when n may be 31+.
 */
public final class BitManipulation {

    private BitManipulation() {
    }

    /** Pairs cancel under XOR. LC 136. */
    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        return x;
    }

    /** bits(i) = bits(i &gt;&gt; 1) + last bit. LC 338. */
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    /** Count set bits by repeatedly clearing the lowest one. LC 191. Works for negatives. */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    /** LC 231. */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /** Bit i of mask set means nums[i] is in the subset. */
    public static List<List<Integer>> subsetsBitmask(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
