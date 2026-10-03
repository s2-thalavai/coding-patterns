package com.leetcode.patterns.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("28. Greedy")
class GreedyTest {

    @Test
    @DisplayName("jump game reachability and min jumps")
    void jumps() {
        assertTrue(Greedy.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(Greedy.canJump(new int[]{3, 2, 1, 0, 4}));
        assertEquals(2, Greedy.jump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(0, Greedy.jump(new int[]{0}));
    }

    @Test
    @DisplayName("non-overlapping intervals (sort by end)")
    void intervals() {
        assertEquals(1, Greedy.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, Greedy.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(2, Greedy.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    @Test
    @DisplayName("gas station")
    void gasStation() {
        assertEquals(3, Greedy.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        assertEquals(-1, Greedy.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
