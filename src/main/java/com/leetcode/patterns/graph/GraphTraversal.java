package com.leetcode.patterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Pattern 18: Graph BFS / DFS.
 *
 * <p>Tree traversal + a visited set. BFS gives shortest paths in unweighted graphs.
 * O(V + E), or O(rows * cols) for grids.
 */
public final class GraphTraversal {

    /** 4-directional moves for grid problems. */
    public static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private GraphTraversal() {
    }

    /** Adjacency list for nodes 0..n-1. */
    public static List<List<Integer>> buildGraph(int n, int[][] edges, boolean directed) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            if (!directed) {
                adj.get(e[1]).add(e[0]);
            }
        }
        return adj;
    }

    /** Grid DFS flood fill; marks visited land as '0' (modifies grid). LC 200. */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sinkIsland(grid, r, c);
                }
            }
        }
        return count;
    }

    private static void sinkIsland(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        for (int[] d : DIRS) {
            sinkIsland(grid, r + d[0], c + d[1]);
        }
    }

    /** Multi-source BFS: seed the queue with every source. LC 994 (modifies grid). */
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : DIRS) {
                    int nr = cell[0] + d[0];
                    int nc = cell[1] + d[1];
                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

    /** BFS shortest path (edge count). Mark visited on ENQUEUE. Returns -1 if unreachable. */
    public static int shortestPathUnweighted(List<List<Integer>> adj, int src, int dst) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == dst) {
                return dist[u];
            }
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }
        return -1;
    }

    /** Iterative DFS with an explicit stack: count connected components. LC 323. */
    public static int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = buildGraph(n, edges, false);
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int start = 0; start < n; start++) {
            if (visited[start]) {
                continue;
            }
            components++;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(start);
            visited[start] = true;
            while (!stack.isEmpty()) {
                int u = stack.pop();
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        stack.push(v);
                    }
                }
            }
        }
        return components;
    }
}
