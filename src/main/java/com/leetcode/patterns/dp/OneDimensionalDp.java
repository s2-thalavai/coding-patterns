package com.leetcode.patterns.dp;

import java.util.Arrays;

/**
 * Pattern 24: 1D Dynamic Programming.
 *
 * <p>Define the state, the recurrence, and the base cases. Start top-down (memo),
 * convert to bottom-up, then shrink space if only the last few states are read.
 */
public final class OneDimensionalDp {

    private OneDimensionalDp() {
    }

    /** Top-down memoization template. LC 70. */
    public static int climbStairs(int n) {
        return climb(n, new int[n + 1]);
    }

    private static int climb(int i, int[] memo) {
        if (i <= 1) {
            return 1;                                // base case
        }
        if (memo[i] != 0) {
            return memo[i];                          // cached
        }
        return memo[i] = climb(i - 1, memo) + climb(i - 2, memo);   // recurrence
    }

    /** Bottom-up, O(1) space: skip vs take. LC 198. */
    public static int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;
        for (int x : nums) {
            int cur = Math.max(prev1, prev2 + x);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    /** dp[a] = min coins for amount a. LC 322. */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);                 // "infinity" without overflow
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) {
                    dp[a] = Math.min(dp[a], dp[a - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /** O(n log n): tails[i] = smallest tail of an increasing run of length i+1. LC 300. */
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0) {
                i = -(i + 1);
            }
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    /** dp[i] = can s[0..i) be segmented. LC 139. */
    public static boolean wordBreak(String s, java.util.List<String> wordDict) {
        java.util.Set<String> words = new java.util.HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
