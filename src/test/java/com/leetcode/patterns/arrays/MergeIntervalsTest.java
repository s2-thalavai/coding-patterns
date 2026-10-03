package com.leetcode.patterns.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("6. Merge Intervals")
class MergeIntervalsTest {

    @Test
    @DisplayName("merge overlapping, touching and nested intervals")
    void merge() {
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}},
                MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        assertArrayEquals(new int[][]{{1, 5}}, MergeIntervals.merge(new int[][]{{1, 4}, {4, 5}}));
        assertArrayEquals(new int[][]{{1, 10}}, MergeIntervals.merge(new int[][]{{1, 10}, {2, 3}}));
    }

    @Test
    @DisplayName("merge does not modify the input")
    void mergeIsPure() {
        int[][] input = {{2, 6}, {1, 3}};
        MergeIntervals.merge(input);
        assertArrayEquals(new int[][]{{2, 6}, {1, 3}}, input);
    }

    @Test
    @DisplayName("minMeetingRooms")
    void meetingRooms() {
        assertEquals(2, MergeIntervals.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        assertEquals(1, MergeIntervals.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
        assertEquals(1, MergeIntervals.minMeetingRooms(new int[][]{{1, 5}, {5, 10}}));
    }
}
