package com.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern 1: Two Pointers.
 *
 * <p>Use when: the input is sorted (or has a monotonic property), you need pairs/triplets,
 * or you need to rewrite an array in place. Turns O(n^2) pair checks into O(n).
 */
public final class TwoPointers {

    private TwoPointers() {
    }

    /** Opposite ends: move the pointer that brings the sum closer to target. LC 167. O(n). */
    public static int[] twoSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {   // CHANGE: condition for moving left
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /** Same direction (read/write): slow marks the write position. LC 26. O(n), modifies input. */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {   // CHANGE: "keep this element?" condition
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    /** Fix one element, two-pointer the rest, skip duplicate values. LC 15. O(n^2). */
    public static List<List<Integer>> threeSum(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;                       // skip duplicate anchor
            }
            int left = i + 1;
            int right = a.length - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];
                if (sum == 0) {
                    result.add(List.of(a[i], a[left], a[right]));
                    while (left < right && a[left] == a[left + 1]) {
                        left++;
                    }
                    while (left < right && a[right] == a[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
