package com.leetcode.patterns.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.leetcode.patterns.model.TreeNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("16. Tree DFS")
class TreeDfsTest {

    @Test
    @DisplayName("max depth")
    void maxDepth() {
        assertEquals(3, TreeDfs.maxDepth(TreeNode.of(3, 9, 20, null, null, 15, 7)));
        assertEquals(0, TreeDfs.maxDepth(null));
    }

    @Test
    @DisplayName("diameter (global answer, return height)")
    void diameter() {
        assertEquals(3, TreeDfs.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5)));
        assertEquals(1, TreeDfs.diameterOfBinaryTree(TreeNode.of(1, 2)));
    }

    @Test
    @DisplayName("root-to-leaf paths with target sum")
    void pathSum() {
        TreeNode root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        assertEquals(List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5)), TreeDfs.pathSum(root, 22));
    }

    @Test
    @DisplayName("validate BST, including deep violations and int extremes")
    void validBst() {
        assertTrue(TreeDfs.isValidBST(TreeNode.of(2, 1, 3)));
        assertFalse(TreeDfs.isValidBST(TreeNode.of(5, 1, 4, null, null, 3, 6)));
        assertFalse(TreeDfs.isValidBST(TreeNode.of(5, 4, 6, null, null, 3, 7)));
        assertTrue(TreeDfs.isValidBST(TreeNode.of(Integer.MAX_VALUE)));
    }

    @Test
    @DisplayName("lowest common ancestor")
    void lca() {
        TreeNode root = TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode n5 = TreeNode.find(root, 5);
        TreeNode n1 = TreeNode.find(root, 1);
        TreeNode n4 = TreeNode.find(root, 4);
        assertSame(root, TreeDfs.lowestCommonAncestor(root, n5, n1));
        assertSame(n5, TreeDfs.lowestCommonAncestor(root, n5, n4));
    }
}
