package com.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern 5: Cyclic Sort.
 *
 * <p>Use when values lie in 1..n: put each value v at index v-1, then scan for misplaced slots.
 * O(n) time, O(1) extra space. Note: these methods modify the input array.
 */
public final class CyclicSort {

    private CyclicSort() {
    }

    /** LC 41. */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]) {
                swap(nums, i, correct);      // don't advance: new value at i needs placing
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /** Values 1..n, each appears once or twice; return those appearing twice. LC 442. */
    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
