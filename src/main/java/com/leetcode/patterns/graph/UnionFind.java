package com.leetcode.patterns.graph;

/**
 * Pattern 20: Union-Find / Disjoint Set Union.
 *
 * <p>Path compression + union by rank: near O(1) amortised per operation.
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);         // path compression
        }
        return parent[x];
    }

    /** Returns false if a and b were already connected (edge closes a cycle). */
    public boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) {
            return false;
        }
        if (rank[ra] < rank[rb]) {               // attach shorter tree under taller
            int t = ra;
            ra = rb;
            rb = t;
        }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) {
            rank[ra]++;
        }
        components--;
        return true;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int components() {
        return components;
    }

    /** First edge that joins two already-connected nodes. Nodes are 1..n. LC 684. */
    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return e;
            }
        }
        return new int[0];
    }

    /** Adjacency matrix -> number of connected groups. LC 547. */
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.components();
    }
}
