package com.leetcode.patterns.dp;

/**
 * Pattern 27: Interval / Partition DP.
 *
 * <p>dp[l][r] = best for a range, built by trying every split k. Iterate by increasing
 * interval length so sub-ranges are ready. Typically O(n^3).
 */
public final class IntervalDp {

    private IntervalDp() {
    }

    /** Think about the LAST balloon k burst in open interval (l, r). LC 312. */
    public static int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] v = new int[n];
        v[0] = 1;
        v[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            v[i + 1] = nums[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][k] + v[left] * v[k] * v[right] + dp[k][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /** dp[i][j] = is s[i..j] a palindrome; classic expand-by-length table. LC 5. */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int best = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > best) {
                    best = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + best);
    }
}
