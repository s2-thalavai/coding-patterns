package com.leetcode.patterns.search;

/**
 * Pattern 12: Modified Binary Search.
 *
 * <p>Find the first index/value where a monotonic condition flips from false to true.
 * Template: half-open [lo, hi), {@code while (lo < hi)}, {@code hi = mid} or {@code lo = mid + 1}.
 */
public final class BinarySearch {

    private BinarySearch() {
    }

    /** First index with nums[i] &gt;= target (nums.length if none). */
    public static int lowerBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;          // avoids overflow
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /** First index with nums[i] &gt; target (nums.length if none). */
    public static int upperBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /** One half around mid is always sorted. LC 33. */
    public static int searchRotated(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {                        // left half sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {                                            // right half sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /** Binary search on the ANSWER: smallest speed that finishes within h hours. LC 875. */
    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        for (int p : piles) {
            hi = Math.max(hi, p);                // CHANGE: answer range
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, mid, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /** CHANGE: the monotonic feasibility check. */
    private static boolean canFinish(int[] piles, int speed, int h) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + speed - 1) / speed;    // ceiling division
        }
        return hours <= h;
    }
}
