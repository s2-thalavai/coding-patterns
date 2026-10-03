package com.leetcode.patterns.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("18. Graph BFS / DFS")
class GraphTraversalTest {

    @Test
    @DisplayName("number of islands (grid DFS)")
    void islands() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        assertEquals(3, GraphTraversal.numIslands(grid));
    }

    @Test
    @DisplayName("rotting oranges (multi-source BFS)")
    void oranges() {
        assertEquals(4, GraphTraversal.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(-1, GraphTraversal.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        assertEquals(0, GraphTraversal.orangesRotting(new int[][]{{0, 2}}));
    }

    @Test
    @DisplayName("unweighted shortest path")
    void shortestPath() {
        List<List<Integer>> graph = GraphTraversal.buildGraph(6,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 4}, {4, 3}}, false);
        assertEquals(2, GraphTraversal.shortestPathUnweighted(graph, 0, 3));
        assertEquals(0, GraphTraversal.shortestPathUnweighted(graph, 2, 2));
        assertEquals(-1, GraphTraversal.shortestPathUnweighted(graph, 0, 5));
    }

    @Test
    @DisplayName("connected components (iterative DFS)")
    void components() {
        assertEquals(2, GraphTraversal.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        assertEquals(3, GraphTraversal.countComponents(3, new int[0][]));
    }
}
