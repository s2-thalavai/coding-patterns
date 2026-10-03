package com.leetcode.patterns.dp;

/**
 * Pattern 26: Knapsack DP.
 *
 * <p>Capacity loop BACKWARDS = each item once (0/1). FORWARDS = items reusable (unbounded).
 */
public final class KnapsackDp {

    private KnapsackDp() {
    }

    /** 0/1 subset sum to half the total. LC 416. */
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int x : nums) {
            for (int s = target; s >= x; s--) {
                dp[s] = dp[s] || dp[s - x];
            }
        }
        return dp[target];
    }

    /** +/- assignment reduces to counting subsets with sum (total + target) / 2. LC 494. */
    public static int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        if (Math.abs(target) > total || (total + target) % 2 != 0) {
            return 0;
        }
        int sum = (total + target) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int s = sum; s >= x; s--) {
                dp[s] += dp[s - x];
            }
        }
        return dp[sum];
    }

    /** Unbounded, count combinations (coins outer loop). LC 518. */
    public static int coinChangeWays(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int a = c; a <= amount; a++) {
                dp[a] += dp[a - c];
            }
        }
        return dp[amount];
    }
}
