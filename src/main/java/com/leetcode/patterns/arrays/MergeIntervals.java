package com.leetcode.patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Pattern 6: Merge Intervals.
 *
 * <p>Sort by start; anything overlapping the current block must come right after it.
 */
public final class MergeIntervals {

    private MergeIntervals() {
    }

    /** LC 56. O(n log n). Input is not modified. */
    public static int[][] merge(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] cur : sorted) {
            int[] last = merged.isEmpty() ? null : merged.get(merged.size() - 1);
            if (last == null || last[1] < cur[0]) {
                merged.add(cur.clone());
            } else {
                last[1] = Math.max(last[1], cur[1]);   // max handles nested intervals
            }
        }
        return merged.toArray(new int[0][]);
    }

    /** Peak overlap via a min-heap of end times. LC 253. O(n log n). */
    public static int minMeetingRooms(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (int[] meeting : sorted) {
            if (!ends.isEmpty() && ends.peek() <= meeting[0]) {
                ends.poll();                            // reuse a freed room
            }
            ends.offer(meeting[1]);
        }
        return ends.size();
    }
}
