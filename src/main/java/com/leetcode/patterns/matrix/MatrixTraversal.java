package com.leetcode.patterns.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern 30: Matrix Traversal.
 */
public final class MatrixTraversal {

    private MatrixTraversal() {
    }

    /** Shrink four boundaries; guard the last two passes. LC 54. */
    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = m.length - 1;
        int left = 0;
        int right = m[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result.add(m[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                result.add(m[r][right]);
            }
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result.add(m[bottom][c]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    result.add(m[r][left]);
                }
                left++;
            }
        }
        return result;
    }

    /** 90 degrees clockwise in place: transpose, then reverse each row. LC 48. */
    public static void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        for (int[] row : m) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int t = row[l];
                row[l] = row[r];
                row[r] = t;
            }
        }
    }

    /** O(1) space: use first row/column as markers. LC 73. */
    public static void setZeroes(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int c = 0; c < cols; c++) {
            if (m[0][c] == 0) {
                firstRowZero = true;
            }
        }
        for (int r = 0; r < rows; r++) {
            if (m[r][0] == 0) {
                firstColZero = true;
            }
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (m[r][c] == 0) {
                    m[r][0] = 0;
                    m[0][c] = 0;
                }
            }
        }
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (m[r][0] == 0 || m[0][c] == 0) {
                    m[r][c] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int c = 0; c < cols; c++) {
                m[0][c] = 0;
            }
        }
        if (firstColZero) {
            for (int r = 0; r < rows; r++) {
                m[r][0] = 0;
            }
        }
    }
}
