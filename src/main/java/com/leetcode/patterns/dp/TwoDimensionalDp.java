package com.leetcode.patterns.dp;

/**
 * Pattern 25: 2D / Grid / String DP.
 *
 * <p>Size string tables (m+1) x (n+1) so row 0 / col 0 are empty-prefix base cases;
 * then dp[i][j] compares charAt(i-1) and charAt(j-1).
 */
public final class TwoDimensionalDp {

    private TwoDimensionalDp() {
    }

    /** LC 62. */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dp[r][c] = (r == 0 || c == 0) ? 1 : dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /** Same recurrence with a single rolling row. LC 64. */
    public static int minPathSum(int[][] grid) {
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    dp[c] = grid[0][0];
                } else if (r == 0) {
                    dp[c] = dp[c - 1] + grid[r][c];
                } else if (c == 0) {
                    dp[c] = dp[c] + grid[r][c];
                } else {
                    dp[c] = Math.min(dp[c], dp[c - 1]) + grid[r][c];
                }
            }
        }
        return dp[cols - 1];
    }

    /** LC 1143. */
    public static int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = a.charAt(i - 1) == b.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /** Diagonal = replace, up = delete, left = insert. LC 72. */
    public static int editDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = a.charAt(i - 1) == b.charAt(j - 1)
                        ? dp[i - 1][j - 1]
                        : 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}
