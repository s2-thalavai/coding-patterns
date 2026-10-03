package com.leetcode.patterns;

import com.leetcode.patterns.arrays.CyclicSort;
import com.leetcode.patterns.arrays.Hashing;
import com.leetcode.patterns.arrays.Kadane;
import com.leetcode.patterns.arrays.MergeIntervals;
import com.leetcode.patterns.arrays.PrefixSum;
import com.leetcode.patterns.arrays.SlidingWindow;
import com.leetcode.patterns.arrays.TwoPointers;
import com.leetcode.patterns.backtracking.Backtracking;
import com.leetcode.patterns.bits.BitManipulation;
import com.leetcode.patterns.design.LRUCache;
import com.leetcode.patterns.design.MinStack;
import com.leetcode.patterns.dp.IntervalDp;
import com.leetcode.patterns.dp.KnapsackDp;
import com.leetcode.patterns.dp.OneDimensionalDp;
import com.leetcode.patterns.dp.TwoDimensionalDp;
import com.leetcode.patterns.graph.GraphTraversal;
import com.leetcode.patterns.graph.ShortestPath;
import com.leetcode.patterns.graph.TopologicalSort;
import com.leetcode.patterns.graph.UnionFind;
import com.leetcode.patterns.greedy.Greedy;
import com.leetcode.patterns.heap.KWayMerge;
import com.leetcode.patterns.heap.MedianFinder;
import com.leetcode.patterns.heap.TopK;
import com.leetcode.patterns.linkedlist.FastSlowPointers;
import com.leetcode.patterns.linkedlist.LinkedListReversal;
import com.leetcode.patterns.matrix.MatrixTraversal;
import com.leetcode.patterns.model.ListNode;
import com.leetcode.patterns.model.TreeNode;
import com.leetcode.patterns.search.BinarySearch;
import com.leetcode.patterns.stack.MonotonicDeque;
import com.leetcode.patterns.stack.MonotonicStack;
import com.leetcode.patterns.tree.TreeBfs;
import com.leetcode.patterns.tree.TreeDfs;
import com.leetcode.patterns.tree.Trie;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Prints one worked example per pattern at startup.
 * Disable with {@code patterns.demo.enabled=false}.
 */
@Component
@ConditionalOnProperty(name = "patterns.demo.enabled", havingValue = "true", matchIfMissing = true)
public class PatternDemoRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println("=== 31 Coding Patterns: one example each ===");

        section("Arrays & Strings");
        show(1, "Two Pointers", "twoSumSorted([2,7,11,15], 9)",
                TwoPointers.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
        show(2, "Sliding Window", "longestSubstringWithoutRepeat(\"abcabcbb\")",
                SlidingWindow.longestSubstringWithoutRepeat("abcabcbb"));
        show(3, "Prefix Sum", "subarraySumEqualsK([1,1,1], 2)",
                PrefixSum.subarraySumEqualsK(new int[]{1, 1, 1}, 2));
        show(4, "Hashing", "longestConsecutive([100,4,200,1,3,2])",
                Hashing.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        show(5, "Cyclic Sort", "firstMissingPositive([3,4,-1,1])",
                CyclicSort.firstMissingPositive(new int[]{3, 4, -1, 1}));
        show(6, "Merge Intervals", "merge([[1,3],[2,6],[8,10],[15,18]])",
                MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        show(7, "Kadane", "maxSubArray([-2,1,-3,4,-1,2,1,-5,4])",
                Kadane.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        section("Linked Lists");
        show(8, "Fast & Slow Pointers", "middle(1->2->3->4->5)",
                FastSlowPointers.middle(ListNode.of(1, 2, 3, 4, 5)).val);
        show(9, "In-place Reversal", "reverseBetween(1->2->3->4->5, 2, 4)",
                LinkedListReversal.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 2, 4));

        section("Stacks & Queues");
        show(10, "Monotonic Stack", "dailyTemperatures([73,74,75,71,69,72,76,73])",
                MonotonicStack.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        show(11, "Monotonic Deque", "maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3)",
                MonotonicDeque.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        section("Searching");
        show(12, "Binary Search", "minEatingSpeed([3,6,7,11], h=8)",
                BinarySearch.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));

        section("Heaps");
        show(13, "Top K", "topKFrequent([1,1,1,2,2,3], 2)",
                TopK.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        MedianFinder medianFinder = new MedianFinder();
        for (int x : new int[]{5, 15, 1, 3}) {
            medianFinder.addNum(x);
        }
        show(14, "Two Heaps", "median of [5,15,1,3]", medianFinder.findMedian());
        show(15, "K-way Merge", "mergeKLists([1,4,5],[1,3,4],[2,6])",
                KWayMerge.mergeKLists(new ListNode[]{
                    ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)}));

        section("Trees & Graphs");
        TreeNode tree = TreeNode.of(3, 9, 20, null, null, 15, 7);
        show(16, "Tree DFS", "maxDepth([3,9,20,null,null,15,7])", TreeDfs.maxDepth(tree));
        show(17, "Tree BFS", "levelOrder([3,9,20,null,null,15,7])", TreeBfs.levelOrder(tree));
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}};
        show(18, "Graph BFS/DFS", "numIslands(4x5 grid)", GraphTraversal.numIslands(grid));
        show(19, "Topological Sort", "findOrder(4, [[1,0],[2,0],[3,1],[3,2]])",
                TopologicalSort.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        show(20, "Union-Find", "findRedundantConnection([[1,2],[1,3],[2,3]])",
                UnionFind.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        show(21, "Dijkstra", "networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], n=4, k=2)",
                ShortestPath.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        Trie trie = new Trie();
        trie.insert("apple");
        show(22, "Trie", "insert(apple); startsWith(app), search(app)",
                trie.startsWith("app") + ", " + trie.search("app"));

        section("Recursion & Optimization");
        show(23, "Backtracking", "permute([1,2,3])", Backtracking.permute(new int[]{1, 2, 3}));
        show(24, "1D DP", "coinChange([1,2,5], 11)",
                OneDimensionalDp.coinChange(new int[]{1, 2, 5}, 11));
        show(25, "2D DP", "editDistance(\"horse\", \"ros\")",
                TwoDimensionalDp.editDistance("horse", "ros"));
        show(26, "Knapsack DP", "canPartition([1,5,11,5])",
                KnapsackDp.canPartition(new int[]{1, 5, 11, 5}));
        show(27, "Interval DP", "maxCoins([3,1,5,8])", IntervalDp.maxCoins(new int[]{3, 1, 5, 8}));
        show(28, "Greedy", "canJump([2,3,1,1,4])", Greedy.canJump(new int[]{2, 3, 1, 1, 4}));

        section("Miscellaneous");
        show(29, "Bit Manipulation", "singleNumber([4,1,2,1,2])",
                BitManipulation.singleNumber(new int[]{4, 1, 2, 1, 2}));
        show(30, "Matrix Traversal", "spiralOrder([[1,2,3],[4,5,6],[7,8,9]])",
                MatrixTraversal.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        show(31, "Design", "LRU(2): put1,put2,get1,put3 -> get(2); MinStack min",
                cache.get(2) + ", " + minStack.getMin());
        System.out.println();
    }

    private static void section(String title) {
        System.out.println();
        System.out.println("-- " + title + " --");
    }

    private static void show(int number, String pattern, String call, Object result) {
        System.out.printf("%2d. %-22s %-58s = %s%n", number, pattern, call, format(result));
    }

    private static String format(Object result) {
        if (result instanceof int[] array) {
            return Arrays.toString(array);
        }
        if (result instanceof int[][] matrix) {
            return Arrays.deepToString(matrix);
        }
        return String.valueOf(result);
    }
}
