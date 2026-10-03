package com.leetcode.patterns.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Model helpers")
class ModelTest {

    @Test
    @DisplayName("ListNode.of builds and toList reads back")
    void listRoundTrip() {
        assertEquals(List.of(1, 2, 3), ListNode.toList(ListNode.of(1, 2, 3)));
        assertNull(ListNode.of());
    }

    @Test
    @DisplayName("TreeNode.of follows LeetCode level-order format")
    void treeFromLevelOrder() {
        TreeNode root = TreeNode.of(3, 9, 20, null, null, 15, 7);
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertNull(root.left.left);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
        assertEquals(20, TreeNode.find(root, 20).val);
        assertNull(TreeNode.of());
    }
}
