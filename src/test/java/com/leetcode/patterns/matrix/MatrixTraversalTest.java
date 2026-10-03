package com.leetcode.patterns.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("30. Matrix Traversal")
class MatrixTraversalTest {

    @Test
    @DisplayName("spiral order: square, wide, tall, single row/column")
    void spiral() {
        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
                MatrixTraversal.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                MatrixTraversal.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        assertEquals(List.of(1, 2, 3), MatrixTraversal.spiralOrder(new int[][]{{1, 2, 3}}));
        assertEquals(List.of(1, 2, 3), MatrixTraversal.spiralOrder(new int[][]{{1}, {2}, {3}}));
    }

    @Test
    @DisplayName("rotate 90 degrees clockwise")
    void rotate() {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixTraversal.rotate(m);
        assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, m);
    }

    @Test
    @DisplayName("set matrix zeroes in O(1) space")
    void setZeroes() {
        int[][] m = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        MatrixTraversal.setZeroes(m);
        assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, m);

        int[][] m2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        MatrixTraversal.setZeroes(m2);
        assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, m2);
    }
}
