package com.leetcode.patterns.graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("20. Union-Find")
class UnionFindTest {

    @Test
    @DisplayName("union, connected and component count")
    void basics() {
        UnionFind uf = new UnionFind(5);
        assertEquals(5, uf.components());
        assertTrue(uf.union(0, 1));
        assertTrue(uf.union(1, 2));
        assertFalse(uf.union(0, 2));
        assertTrue(uf.connected(0, 2));
        assertFalse(uf.connected(0, 3));
        assertEquals(3, uf.components());
    }

    @Test
    @DisplayName("redundant connection")
    void redundant() {
        assertArrayEquals(new int[]{2, 3},
                UnionFind.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        assertArrayEquals(new int[]{1, 4},
                UnionFind.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }

    @Test
    @DisplayName("number of provinces")
    void provinces() {
        assertEquals(2, UnionFind.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        assertEquals(3, UnionFind.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
