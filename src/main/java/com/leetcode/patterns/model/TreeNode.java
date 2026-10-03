package com.leetcode.patterns.model;

import java.util.ArrayDeque;
import java.util.Queue;

/** Binary tree node (LeetCode style) with a level-order builder. */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Builds a tree from LeetCode's level-order format, where null means "no child".
     * Example: {@code TreeNode.of(3, 9, 20, null, null, 15, 7)}.
     */
    public static TreeNode of(Integer... values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (i < values.length) {
            TreeNode parent = queue.poll();
            if (values[i] != null) {
                parent.left = new TreeNode(values[i]);
                queue.offer(parent.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                parent.right = new TreeNode(values[i]);
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }

    /** Returns the first node with the given value (pre-order), or null. */
    public static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = find(root.left, val);
        return left != null ? left : find(root.right, val);
    }
}
