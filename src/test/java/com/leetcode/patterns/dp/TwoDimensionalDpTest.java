package com.leetcode.patterns.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("25. 2D / Grid / String DP")
class TwoDimensionalDpTest {

    @Test
    @DisplayName("unique paths and min path sum")
    void grid() {
        assertEquals(28, TwoDimensionalDp.uniquePaths(3, 7));
        assertEquals(1, TwoDimensionalDp.uniquePaths(1, 1));
        assertEquals(7, TwoDimensionalDp.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    @ParameterizedTest(name = "LCS({0}, {1}) = {2}")
    @CsvSource({"abcde, ace, 3", "abc, abc, 3", "abc, def, 0", "'', abc, 0"})
    @DisplayName("longest common subsequence")
    void lcs(String a, String b, int expected) {
        assertEquals(expected, TwoDimensionalDp.longestCommonSubsequence(a, b));
    }

    @ParameterizedTest(name = "edit({0}, {1}) = {2}")
    @CsvSource({"horse, ros, 3", "intention, execution, 5", "'', abc, 3", "same, same, 0"})
    @DisplayName("edit distance")
    void editDistance(String a, String b, int expected) {
        assertEquals(expected, TwoDimensionalDp.editDistance(a, b));
    }
}
