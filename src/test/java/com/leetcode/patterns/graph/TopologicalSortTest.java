package com.leetcode.patterns.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("19. Topological Sort")
class TopologicalSortTest {

    @Test
    @DisplayName("order respects every prerequisite")
    void validOrder() {
        int[][] prereqs = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = TopologicalSort.findOrder(4, prereqs);
        assertEquals(4, order.length);
        int[] position = new int[4];
        for (int i = 0; i < order.length; i++) {
            position[order[i]] = i;
        }
        for (int[] p : prereqs) {
            assertTrue(position[p[1]] < position[p[0]], p[1] + " must come before " + p[0]);
        }
    }

    @Test
    @DisplayName("cycle yields empty order")
    void cycle() {
        assertEquals(0, TopologicalSort.findOrder(2, new int[][]{{1, 0}, {0, 1}}).length);
        assertFalse(TopologicalSort.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertTrue(TopologicalSort.canFinish(2, new int[][]{{1, 0}}));
    }
}
