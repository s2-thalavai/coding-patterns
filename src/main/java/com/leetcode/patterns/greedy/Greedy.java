package com.leetcode.patterns.greedy;

import java.util.Arrays;

/**
 * Pattern 28: Greedy.
 *
 * <p>Locally best choice, never revisited. Only correct with a proof (usually an exchange
 * argument); if a counterexample exists, use DP.
 */
public final class Greedy {

    private Greedy() {
    }

    /** Track farthest reachable index. LC 55. */
    public static boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    /** Minimum jumps: BFS-like layers over index ranges. LC 45. */
    public static int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    /** Sort by END, keep earliest-finishing. LC 435. Input not modified. */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        long end = Long.MIN_VALUE;
        for (int[] interval : sorted) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                removed++;
            }
        }
        return removed;
    }

    /** If total gas &gt;= total cost, start after the last point where the tank went negative. LC 134. */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
