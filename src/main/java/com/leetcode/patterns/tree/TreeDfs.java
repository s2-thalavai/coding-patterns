package com.leetcode.patterns.tree;

import com.leetcode.patterns.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Pattern 16: Tree DFS.
 *
 * <p>Decide what a node needs FROM its children (bottom-up) or passes DOWN to them (top-down).
 * O(n) time, O(h) recursion stack.
 */
public final class TreeDfs {

    private TreeDfs() {
    }

    /** Bottom-up: combine children's answers. LC 104. */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Bottom-up with a global answer: return height to the parent, update best diameter.
     * LC 543. Same shape as Max Path Sum (LC 124) and Balanced Tree (LC 110).
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] best = {0};
        height(root, best);
        return best[0];
    }

    private static int height(TreeNode node, int[] best) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left, best);
        int right = height(node.right, best);
        best[0] = Math.max(best[0], left + right);   // path through this node
        return 1 + Math.max(left, right);            // what the parent needs
    }

    /** Top-down with a path: backtracking on a tree. LC 113. */
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumDfs(root, target, new ArrayList<>(), result);
        return result;
    }

    private static void pathSumDfs(TreeNode node, int remaining, List<Integer> path,
                                   List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(path));       // copy!
        }
        pathSumDfs(node.left, remaining - node.val, path, result);
        pathSumDfs(node.right, remaining - node.val, path, result);
        path.remove(path.size() - 1);                // undo
    }

    /** Top-down with bounds. LC 98. long bounds handle Integer.MIN/MAX node values. */
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long lo, long hi) {
        if (node == null) {
            return true;
        }
        if (node.val <= lo || node.val >= hi) {
            return false;
        }
        return validate(node.left, lo, node.val) && validate(node.right, node.val, hi);
    }

    /** LC 236. Returns p, q, or their LCA if found in this subtree, else null. */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
