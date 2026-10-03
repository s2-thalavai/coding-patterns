package com.leetcode.patterns.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Pattern 19: Topological Sort (Kahn's algorithm, BFS on in-degrees).
 *
 * <p>Nodes on a cycle never reach in-degree 0, so a short output means a cycle. O(V + E).
 */
public final class TopologicalSort {

    private TopologicalSort() {
    }

    /** Edge [a, b] means b must come before a. Returns empty array on a cycle. LC 210. */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[index++] = u;
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }

    /** LC 207. */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return findOrder(numCourses, prerequisites).length == numCourses;
    }
}
