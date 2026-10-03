package com.leetcode.patterns.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Pattern 21: Weighted Shortest Path.
 *
 * <p>Dijkstra for non-negative weights, O((V + E) log V).
 * Bellman-Ford for negative weights or "at most k edges", O(k * E).
 */
public final class ShortestPath {

    private ShortestPath() {
    }

    /** Dijkstra with lazy deletion. Nodes 1..n, edges {u, v, w}. LC 743. */
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int d = top[1];
            if (d > dist[u]) {
                continue;                        // stale entry: the key line
            }
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int nd = d + edge[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    /** Bellman-Ford limited to k+1 edges; copy the array each round. LC 787. */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] next = cost.clone();
            for (int[] f : flights) {
                if (cost[f[0]] != Integer.MAX_VALUE && cost[f[0]] + f[2] < next[f[1]]) {
                    next[f[1]] = cost[f[0]] + f[2];
                }
            }
            cost = next;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
