package com.leetcode.patterns.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("21. Shortest Path")
class ShortestPathTest {

    @Test
    @DisplayName("Dijkstra network delay")
    void dijkstra() {
        assertEquals(2, ShortestPath.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        assertEquals(-1, ShortestPath.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
        // longer path with fewer hops must lose to cheaper multi-hop path
        assertEquals(3, ShortestPath.networkDelayTime(new int[][]{{1, 2, 10}, {1, 3, 1}, {3, 2, 2}}, 3, 1));
    }

    @Test
    @DisplayName("Bellman-Ford with at most k stops")
    void bellmanFord() {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        assertEquals(700, ShortestPath.findCheapestPrice(4, flights, 0, 3, 1));
        int[][] triangle = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        assertEquals(200, ShortestPath.findCheapestPrice(3, triangle, 0, 2, 1));
        assertEquals(500, ShortestPath.findCheapestPrice(3, triangle, 0, 2, 0));
    }
}
